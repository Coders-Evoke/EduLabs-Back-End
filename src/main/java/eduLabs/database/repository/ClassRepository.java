package eduLabs.database.repository;

import eduLabs.database.model.ClassTableModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassTableModel, String> {

}
