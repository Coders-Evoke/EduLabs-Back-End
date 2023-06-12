package com.example.studentmanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;

    @Column(name = "Title")
    private String title;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Contact_Number")
    private int contactNO;

    @Column(name = "Email")
    private String email;

    @Column(name ="DOB")
    private String dob;

    @Column(name = "Address")
    private String address;

    @Column(name = "Parent_NIC")
    private String parentNic;

    @Column(name = "Password")
    private String password;

    public Student(){

    }

    public Student(String title, String firstName, String lastName, int contactNO, String email, String dob, String address, String parentNic, String password) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNO = contactNO;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.parentNic = parentNic;
        this.password = password;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getContactNO() {
        return contactNO;
    }

    public void setContactNO(int contactNO) {
        this.contactNO = contactNO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentNic() {
        return parentNic;
    }

    public void setParentNic(String parentNic) {
        this.parentNic = parentNic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
