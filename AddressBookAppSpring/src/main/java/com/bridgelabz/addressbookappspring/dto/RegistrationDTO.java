package com.bridgelabz.addressbookappspring.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegistrationDTO {

    @NotEmpty(message = "User name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "user name Invalid")
    private String userName;

    @Email(message = "Enter valid email id")
    private String email;

    @NotEmpty(message = "Password cannot empty")
    @Size(min = 8, message = "Password should minimum 8 character")
    private String password;
}