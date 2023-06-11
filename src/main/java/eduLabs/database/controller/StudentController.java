package eduLabs.database.controller;

import eduLabs.database.exception.NotFoundException;
import eduLabs.database.model.DTOs.StudentInfoDto;
import eduLabs.database.model.StudentTableModel;
import eduLabs.database.repository.StudentRepository;
import eduLabs.database.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;


    @GetMapping("getStudent/{studentId}")
//    public boolean getStudentByID(@PathVariable String studentId){
//        return studentService.checkStudentExist(studentId);
//    }
    public ResponseEntity<StudentInfoDto> getStudentById(@PathVariable String studentId){
        if (studentService.checkStudentExist(studentId)){
            return ResponseEntity.ok(studentService.getStudentById(studentId));
        }
        else {
            throw new NotFoundException("Student not found");
        }
    }

}
