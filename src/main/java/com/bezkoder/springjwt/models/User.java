package com.bezkoder.springjwt.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  @NonNull
  private String username;

  @NotBlank
  @Size(max = 100)
  @Email
  @NonNull
  private String email;

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
  @Size(max = 120)
  @NonNull
  private String password;

  @Column(name = "verification_code", columnDefinition = "TEXT", nullable = true)
  private String verificationCode;


  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))

  private Set<Role> roles = new HashSet<>();

}
