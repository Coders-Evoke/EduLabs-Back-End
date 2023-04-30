package eduLabs.database.service;

import eduLabs.database.model.DuePaymentsTableModel;
import eduLabs.database.model.StudentClass;
import eduLabs.database.model.StudentPaymentModel;
import eduLabs.database.repository.DuePaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DuePaymentsServiceImp implements DuePaymentsService{

    @Autowired
    private DuePaymentsRepository repository;

    public StudentPaymentModel[] returnPaymentInformation(List<DuePaymentsTableModel> duepayment, List<List<String>> classNameFee){
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
    public DuePaymentsTableModel addDuePayments(DuePaymentsTableModel duePayment) {
        return repository.save(duePayment);

    }

    @Override
    public DuePaymentsTableModel updateDuePayments(StudentClass ID, Integer months) {
        DuePaymentsTableModel oldRecord = repository.findById(ID).orElse(null);
        oldRecord.setDueMonths(months);
        return repository.save(oldRecord);
    }


    @Override
    public String deleteStudentClass(StudentClass ID) {
        repository.deleteById(ID);
        return "Student "+ID.getStudentID()+" Left the class " +ID.getClassID();
    }
}
