package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class_table") //specify the table name in the database
public class ClassTableModel {
    @Id //make primary key
    @Column(length = 4)
    private String classID;

//    @Column(length = 6)
//    private String teacherID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherid" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TeacherTableModel teacher;

    @Column(length = 50)
    private String className;

    @Column(length = 2)
    private int grade;

    @Column(length = 3)
    private String dayOfWeek;

    @Column
    private LocalTime time;

    @Column(length = 2)
    private int duration;

    @Column
    private int monthlyFee;

    @Column(length = 5)
    private float teacherShare;

}
