package eduLabs.database.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPaymentDto {

    private String studentID;
    private String classID;
    private String class_name;
    private int monthly_fee;
    private int due_months;

}
