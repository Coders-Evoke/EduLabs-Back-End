package eduLabs.database.controller;

import eduLabs.database.model.DTOs.PaymentTableDto;
import eduLabs.database.model.PaymentTableModel;
import eduLabs.database.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/recordDonePayment")
    public ResponseEntity<PaymentTableDto> recordDonePayment(@RequestBody PaymentTableDto payment){
        return new ResponseEntity<>(this.paymentService.updateMadePayment(payment), HttpStatus.OK);
    }

    @GetMapping("/getDonePayments")
    public ResponseEntity<List<PaymentTableDto>> getDonePayments(){
        return new ResponseEntity<>(this.paymentService.getMadePayments(),HttpStatus.OK);
    }

}
