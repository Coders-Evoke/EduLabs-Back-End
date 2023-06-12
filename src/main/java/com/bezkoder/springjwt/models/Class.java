package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data()
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class")
public class Class implements Serializable{

    @Id
    @Column(name = "classId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String classId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "grade")
    private long grade;

    @Column(name = "type")
    private String type;

    @Column(name = "dayOfWeek")
    private String dayOfWeek;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "duration")
    private String duration;

    @Column(name = "monthlyFee")
    private long monthlyFee;

    @Column(name = "teacherShare")
    private String teacherShare;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "teacherId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Teacher teacher;

    @OneToMany(mappedBy = "classes", fetch = FetchType.LAZY)
    private Set<Enrollment> enrollment = new HashSet<>();

    @JsonIgnore
    public Teacher getTeacher() { return teacher; }

    @JsonIgnore
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    @JsonIgnore
    public Set<Enrollment> getEnrollment() { return enrollment; }

    @JsonIgnore
    public void setEnrollment(Set<Enrollment> enrollment) { this.enrollment = enrollment; }


    // Retrieve teacher details
    public String getTeacherId() { return teacher.getTeacherId();}
    //    public String getTeacherAddress() { return teacher.getAddress();}
//    public String getTeacherEmail() { return teacher.getEmail();}
    public String getTeacherFirstName() { return teacher.getFirstName();}
    public String getTeacherLastName() { return teacher.getLastName();}
//    public String getTeacherNic() { return teacher.getNic();}
//    public String getTeacherTelNo() { return teacher.getTelNo();}
}