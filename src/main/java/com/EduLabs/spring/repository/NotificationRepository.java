package com.EduLabs.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.EduLabs.spring.model.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByTimeContaining(String time);
}
