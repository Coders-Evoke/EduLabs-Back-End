package com.EduLabs.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EduLabs.spring.model.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    List<Timetable> findByDateContaining(String date);
}
