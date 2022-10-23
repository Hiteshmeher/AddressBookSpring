package com.bridgelabz.addressbookappspring.service;

import com.bridgelabz.addressbookappspring.dto.RegistrationDTO;
import com.bridgelabz.addressbookappspring.entity.UserData;
import com.bridgelabz.addressbookappspring.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    LoginRepo loginRepo;


    @Override
    public UserData userRegistration(RegistrationDTO registrationDTO) {
        UserData loginData = null;
        loginData = new UserData(registrationDTO);
        return loginRepo.save(loginData);
    }

    @Override
    public UserData userLogin(String userName, String password) {
        return loginRepo.checkLogin(userName,password);
    }
}
