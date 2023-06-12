package com.EduLabs.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EduLabs.spring.model.Notification;
import com.EduLabs.spring.repository.NotificationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Service
public class NotificationController {

    @Autowired
    NotificationRepository NotificationRepository;

    @GetMapping("/notifications")
    public ResponseEntity<List<Notification>> getAllNotifications(@RequestParam(required = false) String time) {
        try {
            List<Notification> notifications = new ArrayList<Notification>();

            if (time == null)
                NotificationRepository.findAll().forEach(notifications::add);
            else
                NotificationRepository.findByTimeContaining(time).forEach(notifications::add);

            if (notifications.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(notifications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/notifications/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable("id") long id) {
        Optional<Notification> notificationData = NotificationRepository.findById(id);

        if (notificationData.isPresent()) {
            return new ResponseEntity<>(notificationData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/notifications")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        try {

            Notification _notification = NotificationRepository
                    .save(new Notification (notification.message));
            return new ResponseEntity<>(_notification, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/notifications/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable("id") long id, @RequestBody Notification notification) {
        Optional<Notification> notificationData = NotificationRepository.findById(id);

        if (notificationData.isPresent()) {
            Notification _notification = notificationData.get();

//            _notification.time = notification.time;
            _notification.message = notification.message;
            return new ResponseEntity<>(NotificationRepository.save(_notification), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/notifications/{id}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable("id") long id) {
        try {
            NotificationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/notifications")
    public ResponseEntity<HttpStatus> deleteAllNotifications() {
        try {
            NotificationRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
