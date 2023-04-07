package eduLabs.database.service;

import eduLabs.database.model.DuePaymentsModel;
import eduLabs.database.model.StudentClass;
import eduLabs.database.model.StudentPaymentModel;
import eduLabs.database.repository.DuePaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DuePaymentsServiceImp implements DuePaymentsService{

    @Autowired
    private DuePaymentsRepository repository;

    public StudentPaymentModel[] returnPaymentInformation(List<DuePaymentsModel> duepayment, List<List<String>> classNameFee){
        StudentPaymentModel[] studentPaymentModel= new StudentPaymentModel[duepayment.size()];
        for(int x=0; x<duepayment.size(); x++){
            StudentPaymentModel studentPayment = new StudentPaymentModel();
            studentPayment.setStudentID(duepayment.get(x).getId().getStudentID());
            studentPayment.setClassid(duepayment.get(x).getId().getClassID());
            studentPayment.setClass_name(classNameFee.get(x).get(0));
            studentPayment.setMonthly_fee(Integer.parseInt(classNameFee.get(x).get(1)));
            studentPayment.setDue_months(duepayment.get(x).getDueMonths());
            studentPaymentModel[x]=studentPayment;
        }
        return studentPaymentModel;
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


    @Override
    public String deleteStudentClass(StudentClass ID) {
        repository.deleteById(ID);
        return "Student "+ID.getStudentID()+" Left the class " +ID.getClassID();
    }
}
