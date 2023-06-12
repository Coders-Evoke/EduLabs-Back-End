package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.request.SignupRequest;
import com.bezkoder.springjwt.payload.request.StudentSignUpRequest;
import com.bezkoder.springjwt.payload.response.JwtResponse;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.StudentRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String fromEmail;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getFirstname(),
                userDetails.getLastname(),
                userDetails.getAddress(),
                userDetails.getTelno(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getFirstname(),
                signUpRequest.getLastname(),
                signUpRequest.getAddress(),
                signUpRequest.getTelno(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_User)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_Admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "student":
                        Role studentRole = roleRepository.findByName(ERole.ROLE_Student)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(studentRole);

                        break;
                    case "teacher":
                        Role teacherRole = roleRepository.findByName(ERole.ROLE_Teacher)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(teacherRole);

                        break;
                    case "reception":
                        Role receptionRole = roleRepository.findByName(ERole.ROLE_Receptionist)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(receptionRole);

                        break;
                    case "owner":
                        Role ownerRole = roleRepository.findByName(ERole.ROLE_Owner)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(ownerRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_User)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/studentsignup")
    public ResponseEntity<?> registerStudentUser(@Valid @RequestBody StudentSignUpRequest studentSignUpRequest) {
        if (studentRepository.existsByUsername(studentSignUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (studentRepository.existsByEmail(studentSignUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Student user = new Student(
                studentSignUpRequest.getUsername(),
                studentSignUpRequest.getEmail(),
                studentSignUpRequest.getTitle(),
                studentSignUpRequest.getDob(),
                studentSignUpRequest.getFirstname(),
                studentSignUpRequest.getLastname(),
                studentSignUpRequest.getAddress(),
                studentSignUpRequest.getTelno(),
                studentSignUpRequest.getParenttitle(),
                studentSignUpRequest.getParentfirstname(),
                studentSignUpRequest.getParentlastname(),
                studentSignUpRequest.getParenttelno()
        );
        studentRepository.save(user);

        Set<String> roleset = new HashSet<>();
        roleset.add("student");
        roleset.add("user");

        SignupRequest signUpRequest = new SignupRequest(
                studentSignUpRequest.getUsername(),
                studentSignUpRequest.getEmail(),
                studentSignUpRequest.getFirstname(),
                studentSignUpRequest.getLastname(),
                studentSignUpRequest.getAddress(),
                studentSignUpRequest.getTelno(),
                roleset,
                studentSignUpRequest.getPassword()
        );
        return registerUser(signUpRequest);

    }

    @GetMapping("/forgot-password/{email}")
    public ResponseEntity<?> forgotPasssword(@PathVariable String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        String verificationCode = UUID.randomUUID().toString();
        user.setVerificationCode(verificationCode);
        userRepository.save(user);

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setSubject("Forgot Password Verification");
            // change the mail content
            // URL redirected to is "http://localhost:4200/foget-password"
            mimeMessageHelper.setText("<p>To reset password click the button below.</p><br/><a href='http://localhost:4200/change-password?code="+verificationCode+"'>Reset Password</a>", true);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setFrom(fromEmail);
            javaMailSender.send(mimeMessage);

            return ResponseEntity.ok(new MessageResponse("Forgot Password Email Sent Successfully!"));
        } catch (Exception e) {
            throw new IllegalStateException("Failed to send email");
        }
    }

//    @PutMapping("/reset/{verificationCode}")
//    public ResponseEntity<?> resetPassword(@PathVariable String verificationCode, @Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
//        User user = userRepository.findByVerificationCode(verificationCode)
//                .orElseThrow(() -> new RuntimeException("Error: User is not found."));
//
//        user.setPassword(encoder.encode(resetPasswordRequest.getPassword()));
//        userRepository.save(user);
//
//        // Change here.
//        return ResponseEntity.ok(user);
//    }


    @PutMapping("/reset/{username}")
    public ResponseEntity<?> resetPassword(@PathVariable String username, @RequestBody SignupRequest signUpRequest){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));

        User updatedUser= userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }



}
