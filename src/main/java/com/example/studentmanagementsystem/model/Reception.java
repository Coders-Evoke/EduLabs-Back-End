package com.example.studentmanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name="Reception")
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receptionId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email")
    private String email;
    @Column(name = "NIC")
    private String nic;
    @Column(name = "Tel_Number")
    private int telNo;

    @Column(name = "Address")
    private String address;

    @Column(name = "Salary")
    private int salary;

    @Column(name = "Password")
    private String password;

    public Reception() {

    }

    public Reception(String password, String firstName, String lastName, String email, String nic, int telNo, String address, int salary) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nic = nic;
        this.telNo = telNo;
        this.address = address;
        this.salary = salary;
    }

    public int getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(int receptionId) {
        this.receptionId = receptionId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getMobileNumber() {
        return telNo;
    }

    public void setMobileNumber(int telNo) {
        this.telNo = telNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
