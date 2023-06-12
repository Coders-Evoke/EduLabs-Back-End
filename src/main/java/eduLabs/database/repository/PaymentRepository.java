package eduLabs.database.repository;

import eduLabs.database.model.PaymentTableModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentTableModel, String> {

}
