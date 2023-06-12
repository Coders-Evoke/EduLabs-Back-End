package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentTableModel {

    @Id
    private String paymentID;

    @ManyToOne
    @JoinColumn(name = "studentid")
    private StudentTableModel studentTableModel;

    @ManyToOne
    @JoinColumn(name = "classid")
    private ClassTableModel classTableModel;

    @Column
    private int months;

    @Column
    private Date paymentDate;

}




