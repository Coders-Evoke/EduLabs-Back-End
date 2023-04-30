package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentTableModel {

    @Id
    @GeneratedValue
    private long paymentID;

    @Column(length = 6)
    private String studentID;

    @Column(length = 4)
    private String classID;

    @Column
    private int months;

    @Column
    private Date paymentDate;

}




