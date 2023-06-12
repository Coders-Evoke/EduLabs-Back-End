package com.bezkoder.springjwt.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 20)
  private String firstname;

  @NotBlank
  @Size(max = 20)
  private String lastname;

  @NotBlank
  @Size(max = 50)
  private String address;

  @NotBlank
  @Size(max = 10)
  private String telno;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

}
