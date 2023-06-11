package eduLabs.database.service;

import eduLabs.database.model.DTOs.StudentInfoDto;
import eduLabs.database.model.StudentTableModel;

import java.util.Optional;

public interface StudentService {

    public boolean checkStudentExist(String studentId);

    public StudentInfoDto getStudentById (String studentId);
}
