package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enrollment")
public class EnrollmentTableModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "studentid")
    private StudentTableModel studentTableModel;

    @ManyToOne
    @JoinColumn(name = "classid")
    private ClassTableModel classTableModel;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int dueMonths = 0;
}
