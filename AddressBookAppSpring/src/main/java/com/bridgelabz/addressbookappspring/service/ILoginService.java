package com.bridgelabz.addressbookappspring.service;

import com.bridgelabz.addressbookappspring.dto.RegistrationDTO;
import com.bridgelabz.addressbookappspring.entity.UserData;

public interface ILoginService {

    UserData userRegistration(RegistrationDTO registrationDTO);

    UserData userLogin(String userName, String password);
}
