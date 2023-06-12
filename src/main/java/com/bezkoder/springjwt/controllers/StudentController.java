package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.models.Student;
import com.bezkoder.springjwt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //get all students
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:52061"})
    @GetMapping("/student")

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // get student by id rest api
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:52061"})
    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with Student ID: " + studentId));
        return ResponseEntity.ok(student);
    }

    // get student by Username rest api
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:52061"})
    @GetMapping("/student/{studentUsername}")
    public ResponseEntity<Student> getStudentByUsername(@PathVariable String studentUsername) {
        Student student = studentRepository.findByUsername(studentUsername)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with Student ID: " + studentUsername));
        return ResponseEntity.ok(student);
    }
}   
