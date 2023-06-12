package com.EduLabs.spring.Service;

import java.time.LocalDateTime;
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
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications(String time) {
        List<Notification> notifications = new ArrayList<>();

        if (time == null) {
            notifications.addAll(notificationRepository.findAll());
        } else {
            notifications.addAll(notificationRepository.findByTimeContaining(time));
        }

        return notifications;
    }

    public void createNotification(String message) {
        Notification notification = new Notification();
        notification.setTime(LocalDateTime.now());
        notification.setMessage(message);
        notificationRepository.save(notification);
    }

    public Optional<Notification> getNotificationById(long id) {
        return notificationRepository.findById(id);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Optional<Notification> updateNotification(long id, Notification updatedNotification) {
        Optional<Notification> notificationData = notificationRepository.findById(id);

        if (notificationData.isPresent()) {
            Notification notification = notificationData.get();
            notification.setMessage(updatedNotification.getMessage());
            return Optional.of(notificationRepository.save(notification));
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
