package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_payment")

public class DuePaymentsTableModel {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private StudentClass id;

    private int dueMonths;


}

