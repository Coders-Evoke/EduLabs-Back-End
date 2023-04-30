package eduLabs.database.controller;

import eduLabs.database.model.DuePaymentsTableModel;
import eduLabs.database.model.StudentClass;
import eduLabs.database.model.StudentPaymentModel;
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


    @GetMapping("/getDuePayments/{studentId}")
    public StudentPaymentModel[] getDuePaymentsByStudentId(@PathVariable String studentId) {
        List<DuePaymentsTableModel> duePayments = repository.getDuePaymentsQuery(studentId);
        List<List<String>> classnameid = repository.getClassNameFee(studentId);
//        return duePayments;
        return service.returnPaymentInformation(duePayments, classnameid);
    }

    @PostMapping("/addDuePayment")
    public DuePaymentsTableModel addDuePayment(@RequestBody DuePaymentsTableModel duePayments){
        return service.addDuePayments(duePayments);
    }

    @PutMapping("/updatePayment")
    public DuePaymentsTableModel updatePayment(@RequestBody DuePaymentsTableModel payment){
        Optional<DuePaymentsTableModel> duePayment = repository.findById(new StudentClass(payment.getId().getStudentID(), payment.getId().getClassID()));

//        if (duePayment.isPresent()) {
            DuePaymentsTableModel existingPayment = duePayment.get();
            existingPayment.setDueMonths(payment.getDueMonths());
            return repository.save(existingPayment);
//        }
//        else {
//            throw new ResourceNotFoundException("Payment not found for StudentId=" + id.getStudentID() + " and ClassId=" + id.getClassID());
//        }
    }

    @DeleteMapping("/removeStudent")
    public String removeStudent(@RequestBody String studentId){
        repository.deleteStudent(studentId);
        return "Student "+studentId+" has been removed from all the classes.";
    }
    @DeleteMapping("/removeStudentClass")
    public String removeStudentClass(@RequestBody StudentClass id){
        return service.deleteStudentClass(id);
    }
}
