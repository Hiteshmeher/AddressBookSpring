package com.bridgelabz.addressbookappspring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class LoginDTO {
    private String userName;
    private String password;
}