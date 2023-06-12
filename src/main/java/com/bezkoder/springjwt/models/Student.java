package com.bezkoder.springjwt.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @NonNull
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @NonNull
    private String email;

    @NotBlank
    @Size(max = 20)
    @NonNull
    private String title;

    @NotBlank
    @Size(max = 20)
    @NonNull
    private String dob;

    @NotBlank
    @Size(max = 20)
    @NonNull
    private String firstname;

    @NotBlank
    @Size(max = 20)
    @NonNull
    private String lastname;

    @NotBlank
    @Size(max = 50)
    @NonNull
    private String address;

    @NotBlank
    @Size(max = 10)
    @NonNull
    private String telno;

    @NotBlank
    @Size(max = 20)
    @NonNull
    private String parenttitle;

    @NotBlank
    @Size(max = 20)
    @NonNull
    private String parentfirstname;

    @NotBlank
    @Size(max = 20)
    @NonNull
    private String parentlastname;

    @NotBlank
    @Size(max = 20)
    @NonNull
    private String parenttelno;

}

