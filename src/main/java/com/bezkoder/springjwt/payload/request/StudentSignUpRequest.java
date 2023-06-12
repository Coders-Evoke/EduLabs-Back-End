package com.bezkoder.springjwt.payload.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class StudentSignUpRequest {
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String title;

    @NotBlank
    @Size(max = 20)
    private String dob;

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

    @NotBlank
    @Size(max = 20)
    private String parenttitle;

    @NotBlank
    @Size(max = 20)
    private String parentfirstname;

    @NotBlank
    @Size(max = 20)
    private String parentlastname;

    @NotBlank
    @Size(max = 10)
    private String parenttelno;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

}
