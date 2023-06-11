package eduLabs.database.service;

import eduLabs.database.model.ClassTableModel;
import eduLabs.database.model.EnrollmentTableModel;
import eduLabs.database.model.DTOs.StudentPaymentDto;
import eduLabs.database.model.StudentTableModel;
import eduLabs.database.repository.ClassRepository;
import eduLabs.database.repository.EnrollmentRepository;
import eduLabs.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceImp implements EnrollmentService{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public boolean checkEnrollment(String studentId, String classId){
        return enrollmentRepository.checkEnrollment(studentId, classId);
    }

    @Override
    public boolean checkStudent(String studentId){
        return enrollmentRepository.checkStudent(studentId);
    }

    @Override
    public long getEnrollmentId(String studentId, String classId){
        return enrollmentRepository.getEnrollmentId(studentId, classId);
    }

    @Override
    public List<StudentPaymentDto> returnEnrollmentInfo(String StudentId) {
        List<List<String>> results = enrollmentRepository.getEnrollmentWithClassInfo(StudentId);
        List<StudentPaymentDto> enrollmentInfo = new ArrayList<>();
        for (List<String> result : results) {
            StudentPaymentDto temp = new StudentPaymentDto();
            temp.setStudentID(result.get(0));
            temp.setClassID(result.get(1));
            temp.setClass_name(result.get(2));
            temp.setMonthly_fee(Integer.parseInt(result.get(3)));
            temp.setDue_months(Integer.parseInt(result.get(4)));
            enrollmentInfo.add(temp);
        }
        return enrollmentInfo;
    }

    @Override
    public void newEnrollment(String StudentId, String ClassId) {

        EnrollmentTableModel enrollment = new EnrollmentTableModel();

        StudentTableModel student = studentRepository.findById(StudentId)
                .orElseThrow(()-> new RuntimeException("Student Not Found"));

        ClassTableModel classObj = classRepository.findById(ClassId)
                .orElseThrow(()-> new RuntimeException("Class Not Found"));

        enrollment.setStudentTableModel(student);
        enrollment.setClassTableModel(classObj);
        enrollment.setDueMonths(0);

        enrollmentRepository.save(enrollment);

    }

    @Override
    public void updatePayment(String studentid, String classid, int months) {
        EnrollmentTableModel enrollment = enrollmentRepository.findById(getEnrollmentId(studentid, classid)).orElseThrow();
        enrollment.setDueMonths(months);
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void unEnroll(String studentid, String classid) {
        enrollmentRepository.deleteById(getEnrollmentId(studentid, classid));
    }

    @Override
    public void removeStudent(String studentid){

        enrollmentRepository.removeStudent(studentid);
    }

}
