package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.models.Class;
import com.bezkoder.springjwt.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    //get all classes
    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:52061"})
    @GetMapping("/class")
    public List<Class> getAllClasses(){
        return classRepository.findAll();
    }

    // get classes by id rest api
    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:52061"})
    @GetMapping("/class/{classId}")
    public ResponseEntity<Class>getClassById(@PathVariable String classId) {
        Class aClass = classRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("Class not exist with Class ID: " + classId));
        return ResponseEntity.ok(aClass);
    }

}