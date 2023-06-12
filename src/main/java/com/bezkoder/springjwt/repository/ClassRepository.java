package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class,String>{
        }