package eduLabs.database.service;

import eduLabs.database.model.DTOs.PaymentTableDto;
import eduLabs.database.model.PaymentTableModel;

import java.util.List;

public interface PaymentService {

    public PaymentTableDto updateMadePayment(PaymentTableDto payment);
    public List<PaymentTableDto> getMadePayments();

}
