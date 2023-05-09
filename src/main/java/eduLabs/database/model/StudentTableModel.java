package eduLabs.database.model;

import eduLabs.database.model.EnrollmentTableModel;
import eduLabs.database.model.ParentTableModel;
import eduLabs.database.model.PaymentTableModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    private Set<PaymentTableModel> paymentTableModels = new HashSet<>();

    @OneToMany(mappedBy = "studentTableModel")
    private Set<EnrollmentTableModel> enrollmentTableModels = new HashSet<>();

}
