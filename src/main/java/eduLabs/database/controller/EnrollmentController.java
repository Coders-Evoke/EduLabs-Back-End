package eduLabs.database.controller;

import eduLabs.database.model.DTOs.StudentClassDto;
import eduLabs.database.model.DTOs.StudentPaymentDto;
import eduLabs.database.model.DTOs.UpdatePaymentDto;
import eduLabs.database.service.EnrollmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentServiceImp enrollmentService;

    @GetMapping("/getEnrollmentInfo/{StudentId}")
    public ResponseEntity<List<StudentPaymentDto>> getEnrollmentByStudentID(@PathVariable String StudentId){
        List<StudentPaymentDto> enrollments= enrollmentService.returnEnrollmentInfo(StudentId);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @PostMapping("/newEnrollment")
    public ResponseEntity<String> saveNewEnrollment(@RequestBody StudentClassDto studentClassDto){
        if(enrollmentService.checkEnrollment(studentClassDto.getStudentID(),studentClassDto.getClassID())){
            return ResponseEntity.ok("Enrollment Already Exist");
        }
        else {
            enrollmentService.newEnrollment(studentClassDto.getStudentID(), studentClassDto.getClassID());
            return ResponseEntity.ok("Enrollment Created Successfully");
        }
    }

    @PutMapping("/updatePayment")
    public ResponseEntity<String> updatePayment(@RequestBody UpdatePaymentDto paymentDto){
        if(enrollmentService.checkEnrollment(paymentDto.getStudentID(), paymentDto.getClassID())){
            enrollmentService.updatePayment(paymentDto.getStudentID(), paymentDto.getClassID(), paymentDto.getMonths());
            return new ResponseEntity(paymentDto, HttpStatus.OK);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/unenroll")
    public ResponseEntity<String> unenrollFromClass(@RequestBody StudentClassDto studentClassDto){
        if(enrollmentService.checkEnrollment(studentClassDto.getStudentID(), studentClassDto.getClassID())){
            enrollmentService.unEnroll(studentClassDto.getStudentID(), studentClassDto.getClassID());
            return ResponseEntity.ok("Successfully unenrolled");
        }
        else{
            return ResponseEntity.ok("No enrollment found");
        }
    }

    @DeleteMapping("/removeStudent/{studentID}")
    public ResponseEntity<String> removeStudent(@PathVariable String studentID){
        if(enrollmentService.checkStudent(studentID)){
            enrollmentService.removeStudent(studentID);
            return ResponseEntity.ok("Student Removed Successfully");
        }
        else {
            return ResponseEntity.ok("No such student found");
        }
    }

}
