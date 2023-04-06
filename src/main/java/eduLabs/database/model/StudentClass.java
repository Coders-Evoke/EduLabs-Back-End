package eduLabs.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

//This class was made because DuePaymentsModel has a composite key.
@Embeddable
public class StudentClass implements Serializable {


    @Column(length = 6)
    private String studentID;

    @Column(length = 4)
    private String classID;

    public StudentClass(){

    }
    public StudentClass(String studentID, String classID){
        this.classID=classID;
        this.studentID=studentID;

    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
