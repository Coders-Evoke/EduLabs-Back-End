package com.EduLabs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EduLabs.spring.model.Notification;
import com.EduLabs.spring.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications(String time) {
        List<Notification> notifications = new ArrayList<>();

        if (time == null) {
            notificationRepository.findAll().forEach(notifications::add);
        } else {
            notificationRepository.findByTimeContaining(time).forEach(notifications::add);
        }

        return notifications;
    }

    public Optional<Notification> getNotificationById(long id) {
        return notificationRepository.findById(id);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Optional<Notification> updateNotification(long id, Notification notification) {
        Optional<Notification> notificationData = notificationRepository.findById(id);

        if (notificationData.isPresent()) {
            Notification _notification = notificationData.get();
            _notification.setMessage(notification.getMessage());
            return Optional.of(notificationRepository.save(_notification));
        } else {
            return Optional.empty();
        }
    }

    public void deleteNotification(long id) {
        notificationRepository.deleteById(id);
    }

    public void deleteAllNotifications() {
        notificationRepository.deleteAll();
    }
}
