package com.EduLabs.spring.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "time")
    public LocalDateTime time;

    @Column(name = "message")
    public String message;


    public void setMessage(String message) {
            this.message = message;
        }


    public Notification(String message) {
        this.time = LocalDateTime.now();
        this.message = message;
    }

    public Notification() {

    }


}
