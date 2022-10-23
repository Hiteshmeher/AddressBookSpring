package com.bridgelabz.addressbookappspring.entity;

import com.bridgelabz.addressbookappspring.dto.RegistrationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long userId;
    private String userName;
    private String email;
    private String password;

    public UserData(RegistrationDTO registrationDTO){
        this.userName = registrationDTO.getUserName();
        this.email = registrationDTO.getEmail();
        this.password = registrationDTO.getPassword();
    }
}
