package eduLabs.database.repository;

import eduLabs.database.model.StudentTableModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentTableModel, String> {

}
