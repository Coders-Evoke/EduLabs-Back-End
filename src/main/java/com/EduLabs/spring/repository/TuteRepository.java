package com.EduLabs.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EduLabs.spring.model.Tute;

public interface TuteRepository extends JpaRepository<Tute, Long> {
  List<Tute> findByTitleContaining(String title);
}
