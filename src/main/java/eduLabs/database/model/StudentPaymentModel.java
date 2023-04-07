package eduLabs.database.model;

public class StudentPaymentModel {

    private String studentID;
    private String classid;
    private String class_name;
    private int monthly_fee;
    private int due_months;

    //getters and setters

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getMonthly_fee() {
        return monthly_fee;
    }

    public void setMonthly_fee(int monthly_fee) {
        this.monthly_fee = monthly_fee;
    }

    public int getDue_months() {
        return due_months;
    }

    public void setDue_months(int due_months) {
        this.due_months = due_months;
    }
}
