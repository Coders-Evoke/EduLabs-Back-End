package eduLabs.database.service;

import eduLabs.database.model.DuePaymentsTableModel;
import eduLabs.database.model.StudentClass;
import eduLabs.database.model.StudentPaymentModel;

import java.util.List;

public interface DuePaymentsService {

    public StudentPaymentModel[] returnPaymentInformation(List<DuePaymentsTableModel> duepayment, List<List<String>> classNameFee);
    public DuePaymentsTableModel addDuePayments(DuePaymentsTableModel duePayment);
    public DuePaymentsTableModel updateDuePayments(StudentClass ID, Integer months);

//    public  String deleteStudent(String studentId);
    public String deleteStudentClass(StudentClass ID);
}
