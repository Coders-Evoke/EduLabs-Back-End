package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class_table") //specify the table name in the database
public class ClassModel {
    @Id //make primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 4)
    private String classID;

    @Column(length = 50)
    private String className;

    private int monthlyFee;

    //Create Getters and setters for each private variables

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    //getters anc setters done.
}
