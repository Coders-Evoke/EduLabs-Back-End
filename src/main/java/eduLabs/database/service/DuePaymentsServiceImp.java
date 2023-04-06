package eduLabs.database.service;

import eduLabs.database.model.DuePaymentsModel;
import eduLabs.database.model.StudentClass;
import eduLabs.database.repository.DuePaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class DuePaymentsServiceImp implements DuePaymentsService{

    @Autowired
    private DuePaymentsRepository repository;

    @Override
    public Optional<DuePaymentsModel> getDuePayments(String studentId) {
        System.out.println(studentId);
        return repository.findById(new StudentClass("S0002","%"));
    }


    @Override
    public DuePaymentsModel addDuePayments(DuePaymentsModel duePayment) {
        return repository.save(duePayment);

    }

    @Override
    public DuePaymentsModel updateDuePayments(StudentClass ID, Integer months) {
        DuePaymentsModel oldRecord = repository.findById(ID).orElse(null);
        oldRecord.setDueMonths(months);
        return repository.save(oldRecord);
    }
}
