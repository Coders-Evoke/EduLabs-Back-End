package eduLabs.database.service;


import eduLabs.database.model.DTOs.StudentInfoDto;
import eduLabs.database.model.StudentTableModel;
import eduLabs.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public boolean checkStudentExist(String studentId) {
        return studentRepository.existsById(studentId);
    }

    @Override
    public StudentInfoDto getStudentById(String studentId) {
            StudentTableModel student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException());

            StudentInfoDto studentInfo = new StudentInfoDto();
            studentInfo.setStudentId(student.getStudentID());
            studentInfo.setTitle(student.getTitle());
            studentInfo.setFirstName(student.getFirstName());
            studentInfo.setLastName(student.getLastName());
            studentInfo.setEmail(student.getEmail());
            studentInfo.setContactNo(student.getContactNo());

            return studentInfo;

    }
}
