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
//@IdClass(StudentClass.class)
public class DuePaymentsModel {

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 6)
    private String studentId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 4)
    private String classID;

     */

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

    //Create Getters and setters for each private variables


//    public String getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getClassID() {
//        return classID;
//    }
//
//    public void setClassID(String classID) {
//        this.classID = classID;
//    }

    public int getDueMonths() {
        return dueMonths;
    }

    public void setDueMonths(int dueMonths) {
        this.dueMonths = dueMonths;
    }
}

