package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.exception.ResourceNotFoundException;
import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    public StudentRepository studentRepository;

    @PostMapping("/student")
    public Student createOwner(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity <Map<String, Boolean>>deleteStudent(@PathVariable int id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Reception not exist with Id:"+id));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
