package eduLabs.database.controller;

import eduLabs.database.model.DuePaymentsModel;
import eduLabs.database.model.StudentClass;
import eduLabs.database.repository.DuePaymentsRepository;
import eduLabs.database.service.DuePaymentsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class DuePaymentsController {

    @Autowired
    private DuePaymentsRepository repository;

    @Autowired
    private DuePaymentsServiceImp service;

//    @GetMapping("/getDuePayments")
//    public Optional<DuePaymentsModel> getDuePayments(@RequestBody String StudentId){
//        return service.getDuePayments(StudentId);
//    }

    @GetMapping("/getDuePayments/{studentId}")
    public List<DuePaymentsModel> getDuePaymentsByStudentId(@PathVariable String studentId) {
        String sql = "SELECT * FROM student_payment WHERE studentid = ?";
        List<DuePaymentsModel> duePayments = repository.getDuePaymentsQuery(studentId);
        return duePayments;
    }

    @PostMapping("/addDuePayment")
    public DuePaymentsModel addDuePayment(@RequestBody DuePaymentsModel duePayments){
        return service.addDuePayments(duePayments);
    }

    @PutMapping("/updatePayment")
    public DuePaymentsModel updatePayment(@RequestBody DuePaymentsModel payment){
//        System.out.println(id);
//        System.out.println(months);
//        return service.updateDuePayments(id, months);
        Optional<DuePaymentsModel> duePayment = repository.findById(new StudentClass(payment.getId().getStudentID(), payment.getId().getClassID()));

//        if (duePayment.isPresent()) {
            DuePaymentsModel existingPayment = duePayment.get();
            existingPayment.setDueMonths(payment.getDueMonths());
            return repository.save(existingPayment);
//        }
//        else {
//            throw new ResourceNotFoundException("Payment not found for StudentId=" + id.getStudentID() + " and ClassId=" + id.getClassID());
//        }
    }

}
