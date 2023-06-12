package com.bezkoder.springjwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('User') or hasRole('Student') or hasRole('Admin') or hasRole('Teacher') or hasRole('Receptionist') or hasRole('Owner')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/student")
  @PreAuthorize("hasRole('Student')")
  public String studentAccess() {
    return "Student Content.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('Admin')")
  public String adminAccess() {
    return "Admin Content.";
  }

  @GetMapping("/teacher")
  @PreAuthorize("hasRole('Teacher')")
  public String teacherAccess() {
    return "Teacher Content.";
  }

  @GetMapping("/receptionist")
  @PreAuthorize("hasRole('Receptionist')")
  public String receptionistAccess() {
    return "Receptionist Content.";
  }

  @GetMapping("/owner")
  @PreAuthorize("hasRole('Owner')")
  public String ownerAccess() {
    return "Owner Content.";
  }
}
