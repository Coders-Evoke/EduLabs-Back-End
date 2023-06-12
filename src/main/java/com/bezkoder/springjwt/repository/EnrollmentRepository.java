package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,String>{
}