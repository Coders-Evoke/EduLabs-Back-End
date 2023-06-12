package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.models.Enrollment;
import com.bezkoder.springjwt.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/")
public class EnrollmentController{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    //get all enrollments
    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:52061"})
    @GetMapping("/enrollment")
    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepository.findAll();
    }

    // get enrollment by id rest api
    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:52061"})
    @GetMapping("/enrollment/{enrollmentId}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable String enrollmentId){
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not exist with Enrollment ID: " + enrollmentId ));
        return ResponseEntity.ok(enrollment);
}

}
