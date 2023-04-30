package eduLabs.database.model;

import lombok.Data;

@Data
public class StudentPaymentModel {

    private String studentID;
    private String classid;
    private String class_name;
    private int monthly_fee;
    private int due_months;
    
}
