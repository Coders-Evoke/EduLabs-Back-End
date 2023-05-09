package eduLabs.database.service;

import eduLabs.database.model.DTOs.StudentPaymentDto;

import java.util.List;

public interface EnrollmentService {

    public boolean checkEnrollment(String StudentId, String ClassId);
    public boolean checkStudent(String studentId);
    public long getEnrollmentId(String studentId, String classId);
    public List<StudentPaymentDto> returnEnrollmentInfo(String StudentId);
    public void newEnrollment(String StudentId, String ClassId);
    public void updatePayment(String studentid, String classid, int months);
    public void unEnroll(String studentid, String classid);
    public void removeStudent(String studentid);
}
