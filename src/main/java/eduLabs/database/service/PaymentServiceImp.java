package eduLabs.database.service;

import eduLabs.database.model.ClassTableModel;
import eduLabs.database.model.DTOs.PaymentTableDto;
import eduLabs.database.model.PaymentTableModel;
import eduLabs.database.model.StudentTableModel;
import eduLabs.database.repository.ClassRepository;
import eduLabs.database.repository.PaymentRepository;
import eduLabs.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImp implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public PaymentTableDto updateMadePayment(PaymentTableDto payment) {
        PaymentTableModel paymentTableModel = new PaymentTableModel();
        ClassTableModel classTable = this.classRepository.findById(payment.getClassId()).orElseThrow();
        StudentTableModel studentTable = this.studentRepository.findById(payment.getStudentId()).orElseThrow();
        System.out.println(" 33 " + payment.getPaymentID());
        paymentTableModel.setPaymentID(payment.getPaymentID());
        System.out.println(" 35 "+paymentTableModel.getPaymentID());
        paymentTableModel.setStudentTableModel(studentTable);
        paymentTableModel.setClassTableModel(classTable);
        paymentTableModel.setMonths(payment.getMonths());
        paymentTableModel.setPaymentDate(payment.getPaymentDate());

        this.paymentRepository.save(paymentTableModel);
        return payment;

    }

    @Override
    public List<PaymentTableDto> getMadePayments() {
        List<PaymentTableModel> payments = this.paymentRepository.findAll();
        List<PaymentTableDto> paymentsReturnList = new ArrayList<>();

        for (PaymentTableModel payment : payments){
            PaymentTableDto temp = new PaymentTableDto();
            temp.setPaymentID(payment.getPaymentID());
            temp.setStudentId(payment.getStudentTableModel().getStudentID());
            temp.setClassId(payment.getClassTableModel().getClassID());
            temp.setMonths(payment.getMonths());
            temp.setPaymentDate(payment.getPaymentDate());

            paymentsReturnList.add(temp);
        }
        return paymentsReturnList;
    }
}
