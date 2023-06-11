package eduLabs.database.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassFeesInfoDto {

    private String classID;
    private String className;
    private String teacherID;
    private int grade;
    private int monthlyFee;
}
