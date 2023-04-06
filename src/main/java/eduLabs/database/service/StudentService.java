package eduLabs.database.service;

import eduLabs.database.model.Student;
import eduLabs.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
      //post
    public Student saveStudent(Student student){
       return repository.save(student);

    }

    public List<Student> saveStudents(List<Student> students){
        return repository.saveAll(students);

    }

    //get

    public List<Student> getStudents(){
        return  repository.findAll();
    }

    public Student getStudentById(int studentId){
        return  repository.findById(studentId).orElse(null);
    }

    //delete

    public  String deleteStudent(int studentId){
        repository.deleteById(studentId);
        return "Student Removed " +studentId;
    }

    //update
    public  Student updateStudent(Student student){
        Student existingStudent=repository.findById(student.getStudentId()).orElse(null);

        existingStudent.setStudentPassword(student.getStudentPassword());
        existingStudent.setStudentTitle(student.getStudentTitle());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setContactNo(student.getContactNo());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDob(student.getDob());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setParentId(student.getParentId());
        return repository.save(existingStudent);
    }
}
