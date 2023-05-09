package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parent")
public class ParentTableModel {

    @Id
    @Column (length = 12)
    private long parentNIC;

    @Column (length = 4)
    private String title;

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 10)
    private  String contactNo;

    @Column
    private String address;

    @OneToMany(mappedBy = "parentTableModel")
    private List<StudentTableModel> studentTableModels;
}
