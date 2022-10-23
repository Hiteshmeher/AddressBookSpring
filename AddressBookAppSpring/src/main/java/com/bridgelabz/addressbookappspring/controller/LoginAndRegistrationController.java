package com.bridgelabz.addressbookappspring.controller;

import com.bridgelabz.addressbookappspring.dto.RegistrationDTO;
import com.bridgelabz.addressbookappspring.dto.ResponseDTO;
import com.bridgelabz.addressbookappspring.entity.UserData;
import com.bridgelabz.addressbookappspring.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginAndRegistrationController {

    @Autowired
    private ILoginService iLoginService;

    /**
     *
     * @param registrationDTO
     * Register a user using username, email and password
     */
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> resisterAccount(@RequestBody RegistrationDTO registrationDTO){
        UserData userData = null;
        userData = iLoginService.userRegistration(registrationDTO);
        ResponseDTO responseDTO = new ResponseDTO("Registration successful", userData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     *
     * @param userName
     * @param password
     * Login User using username and password
     */
    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> loginAccount(@RequestParam String userName ,@RequestParam String password){
        UserData userData = null;
        userData = iLoginService.userLogin(userName,password);
        ResponseDTO responseDTO = new ResponseDTO("Login  Successful",userData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
