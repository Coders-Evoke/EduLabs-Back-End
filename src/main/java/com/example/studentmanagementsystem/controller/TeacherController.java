package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.exception.ResourceNotFoundException;
import com.example.studentmanagementsystem.model.Teacher;
import com.example.studentmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    //Get all teachers
    @GetMapping("/teacher")
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    //Create teachers rest api
    @PostMapping("/teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher){

        return teacherRepository.save(teacher);
    }

    //Get teacher by id rest api
    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacherByID(@PathVariable int id){
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Reception not exist with Id:"+id));
        return ResponseEntity.ok(teacher);
    }

    //Update teacher rest api
    @PutMapping("/teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable int id, @RequestBody Teacher teacherDetails){
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Reception not exist with Id:"+id));
        teacher.setFirstName(teacherDetails.getFirstName());
        teacher.setLastName(teacherDetails.getLastName());
        teacher.setMobileNumber(teacherDetails.getMobileNumber());
        teacher.setAddress(teacherDetails.getAddress());

        Teacher updatedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity <Map<String, Boolean>>deleteTeacher(@PathVariable int id){
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Reception not exist with Id:"+id));

        teacherRepository.delete(teacher);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
