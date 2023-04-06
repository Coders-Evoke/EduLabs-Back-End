package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student_Table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentPassword;
    private String studentTitle;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;
    private String dob;
    private String address;
    private String parentId;



}
