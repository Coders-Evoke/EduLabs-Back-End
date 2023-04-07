package eduLabs.database.service;

import eduLabs.database.model.DuePaymentsModel;
import eduLabs.database.model.StudentClass;
import eduLabs.database.model.StudentPaymentModel;

import java.util.List;
import java.util.Optional;

public interface DuePaymentsService {

    public StudentPaymentModel[] returnPaymentInformation(List<DuePaymentsModel> duepayment, List<List<String>> classNameFee);
    public DuePaymentsModel addDuePayments(DuePaymentsModel duePayment);
    public DuePaymentsModel updateDuePayments(StudentClass ID, Integer months);

//    public  String deleteStudent(String studentId);
    public String deleteStudentClass(StudentClass ID);
}
