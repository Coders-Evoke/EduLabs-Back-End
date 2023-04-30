package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reception")
public class ReceptionTableModel {
    @Id
    @Column(length = 6)
    private String receptionID;

    @Column(length = 20)
    private String password;

    @Column(length = 12)
    private long NIC;

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
    private String address;

    @Column
    private Float salary;
}
