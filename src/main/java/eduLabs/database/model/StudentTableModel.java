package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentTableModel {

    @Id
    @Column(length = 6)
    private String studentID;

    @Column(length = 20)
    private String password;

    @Column(length = 4)
    private String title;

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 10)
    private  String contactNo;

    @Column(length = 40)
    private String email;

    @Column
    private LocalDate dob;

    @Column
    private String address;

    @ManyToOne()
    @JoinColumn(name = "parentnic")
    private ParentTableModel parentTableModel;

    @OneToMany(mappedBy = "studentTableModel")
    private List<PaymentTableModel> paymentTableModels;

    @OneToMany(mappedBy = "studentTableModel")
    private List<AttendanceTableModel> attendanceTableModels;

}
