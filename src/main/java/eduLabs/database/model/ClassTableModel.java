package eduLabs.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class_table")
public class ClassTableModel {
    @Id
    @Column(length = 4)
    private String classID;

    @ManyToOne
    @JoinColumn(name = "teacherid")
    private TeacherTableModel teacherTableModel;

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

    //Foreign keys

    @OneToMany(mappedBy = "classTableModel")
    private List<PaymentTableModel> paymentTableModels;

    @OneToMany(mappedBy = "classTableModel")
    private List<TuteTableModel> tuteTableModels;

    @OneToMany(mappedBy = "classTableModel")
    private List<AttendanceTableModel> attendanceTableModels;

}
