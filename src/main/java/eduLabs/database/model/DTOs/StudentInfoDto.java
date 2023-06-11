package eduLabs.database.model.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoDto {

    private String studentId;
    private String title;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;

}
