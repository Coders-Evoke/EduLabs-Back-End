package com.EduLabs.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "timetables")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "subjectID")
    private String subjectID;

    @Column(name = "subjectName")
    private String subjectName;

    public Timetable() {

    }

    public Timetable(String date, String time, String subjectID, String subjectName) {
        this.date = date;
        this.time = time;
        this.subjectID = subjectID;
        this.subjectName = subjectName;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", date=" + date + ", time=" + time + ", subjectID=" + subjectID + ", subjectName=" + subjectName + "]";
    }

}
