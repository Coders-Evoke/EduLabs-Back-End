package eduLabs.database.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassTableDto {
    private String classID;
    private String teacherId;
    private String className;
    private int grade;
    private String dayOfWeek;
    private LocalTime time;
    private int duration;
    private int monthlyFee;
    private float teacherShare;
}
