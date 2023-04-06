package eduLabs.database.model;

public class StudentPaymentModel {

    private String classID;
    private String className;
    private int monthlyFee;
    private int dueMonths;

    //getters and setters


    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public int getDueMonths() {
        return dueMonths;
    }

    public void setDueMonths(int dueMonths) {
        this.dueMonths = dueMonths;
    }
}
