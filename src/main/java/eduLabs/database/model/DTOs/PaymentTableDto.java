package eduLabs.database.model.DTOs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTableDto {

    private String paymentID;
    private String studentId;
    private String classId;
    private int months;
    private Date paymentDate;
}
