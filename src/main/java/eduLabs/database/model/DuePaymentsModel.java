package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_payment")

public class DuePaymentsModel {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private StudentClass id;

    private int dueMonths;


    public StudentClass getId() {
        return id;
    }

    public void setId(StudentClass id) {
        this.id = id;
    }

    public int getDueMonths() {
        return dueMonths;
    }

    public void setDueMonths(int dueMonths) {
        this.dueMonths = dueMonths;
    }
}

