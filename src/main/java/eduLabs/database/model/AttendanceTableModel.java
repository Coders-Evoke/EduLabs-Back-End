package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendance")
public class AttendanceTableModel {

    @Id
//    @Column(length = 6)
//    private String studentID;
    @ManyToOne
    @JoinColumn(name = "studentid")
    private StudentTableModel studentTableModel;

    @Id
//    @Column(length = 4)
//    private String classID;
    @ManyToOne
    @JoinColumn(name = "classid")
    private ClassTableModel classTableModel;

    @Id
    @Column(length = 4)
    private int year;

    @Column
    private int January;

    @Column
    private int February;

    @Column
    private int March;

    @Column
    private int April;

    @Column
    private int May;

    @Column
    private int June;

    @Column
    private int July;

    @Column
    private int August;

    @Column
    private int September;

    @Column
    private int October;

    @Column
    private int November;

    @Column
    private int December;
}




