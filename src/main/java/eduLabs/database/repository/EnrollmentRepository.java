package eduLabs.database.repository;

import eduLabs.database.model.EnrollmentTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository <EnrollmentTableModel, Long> {

    @Query(value = "SELECT e.studentid, e.classid, c.class_name, c.monthly_fee, e.due_months FROM enrollment e JOIN class_table c ON e.classid=c.classid WHERE e.studentid = :StudentId", nativeQuery = true)
    List<List<String>> getEnrollmentWithClassInfo(@Param("StudentId") String StudentId);

    @Query(value = "SELECT enrollment_id FROM enrollment WHERE studentid = :StudentId AND classid = :ClassId", nativeQuery = true)
    int getEnrollmentId(@Param("StudentId") String StudentId, @Param("ClassId") String ClassId);

    @Query(value = "SELECT CASE WHEN EXISTS " +
            "(SELECT * FROM enrollment WHERE studentid = :StudentId AND classid = :ClassId )" +
            "THEN 'TRUE' ELSE 'FALSE' END", nativeQuery = true)
    Boolean checkEnrollment(@Param("StudentId") String StudentId, @Param("ClassId") String ClassId);

    @Query(value = "SELECT CASE WHEN EXISTS " +
            "(SELECT * FROM enrollment WHERE studentid = :StudentId)" +
            "THEN 'TRUE' ELSE 'FALSE' END", nativeQuery = true)
    Boolean checkStudent(@Param("StudentId") String StudentId);

    @Modifying
    @Query(value = "DELETE FROM enrollment WHERE studentid = :StudentId", nativeQuery = true)
    void removeStudent(@Param("StudentId") String StudentId);

}
