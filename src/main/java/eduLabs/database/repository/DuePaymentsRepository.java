package eduLabs.database.repository;

import eduLabs.database.model.DuePaymentsModel;
import eduLabs.database.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DuePaymentsRepository extends JpaRepository<DuePaymentsModel, StudentClass> {
    @Query(value = "SELECT * FROM student_payment WHERE studentid = :studentId", nativeQuery = true)
    List<DuePaymentsModel> getDuePaymentsQuery(@Param("studentId") String studentId);
}
