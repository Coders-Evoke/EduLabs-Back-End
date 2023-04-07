package eduLabs.database.repository;

import eduLabs.database.model.DuePaymentsModel;
import eduLabs.database.model.StudentClass;
import eduLabs.database.model.StudentPaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DuePaymentsRepository extends JpaRepository<DuePaymentsModel, StudentClass> {

    @Query(value = "SELECT * FROM student_payment WHERE studentid = :studentId", nativeQuery = true)
    List<DuePaymentsModel> getDuePaymentsQuery(@Param("studentId") String studentId);

    @Query(value = "SELECT ct.class_name, ct.monthly_fee FROM student_payment sp " +
            "JOIN class_table ct ON sp.classid=ct.classid " +
            "WHERE sp.studentid=:studentId", nativeQuery = true)
    List<List<String>> getClassNameFee(@Param("studentId") String studentId);

    @Modifying
    @Query(value = "DELETE FROM student_payment WHERE studentid = :studentId", nativeQuery = true)
    void deleteStudent(@Param("studentId") String studentId);
}
