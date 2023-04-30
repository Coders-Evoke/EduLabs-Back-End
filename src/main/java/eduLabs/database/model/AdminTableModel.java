package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class AdminTableModel {
    @Id
    @Column(length = 6)
    private String adminID;

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
}
