package eduLabs.database.model.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//This class was made because DuePaymentsModel has a composite key.
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentClassDto implements Serializable {

    @Column(length = 6)
    private String studentID;

    @Column(length = 4)
    private String classID;

}
