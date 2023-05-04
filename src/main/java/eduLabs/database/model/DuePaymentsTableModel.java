package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_payment")

public class DuePaymentsTableModel {

    @EmbeddedId
    private StudentClass id;

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
//    private StudentTableModel studentTableModel;

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "classid", referencedColumnName = "classid")
//    private ClassTableModel classTableModel;

    private int dueMonths;


}

