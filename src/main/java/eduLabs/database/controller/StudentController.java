package eduLabs.database.controller;
import eduLabs.database.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eduLabs.database.service.StudentService;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){

        return  service.saveStudent(student);
    }

    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student>  students){

        return  service.saveStudents(students);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){

        return service.getStudents();
    }

    @GetMapping("/studentById/{studentId}")
    public  Student findStudentById(@PathVariable int studentId){

        return service.getStudentById(studentId);
    }


    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){

        return service.updateStudent(student);
    }

    @DeleteMapping("/delete{studentId}")
    public String deleteStudent(@PathVariable int studentId){

        return service.deleteStudent(studentId);
    }


}
