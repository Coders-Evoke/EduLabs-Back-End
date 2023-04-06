package eduLabs.database.repository;

import eduLabs.database.model.DuePaymentsModel;
import eduLabs.database.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
