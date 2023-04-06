package eduLabs.database.service;

import eduLabs.database.model.DuePaymentsModel;
import eduLabs.database.model.StudentClass;

import java.util.List;
import java.util.Optional;

public interface DuePaymentsService {

    public Optional<DuePaymentsModel> getDuePayments(String studentId);

    public DuePaymentsModel addDuePayments(DuePaymentsModel duePayment);

    public DuePaymentsModel updateDuePayments(StudentClass ID, Integer months);
}
