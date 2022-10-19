package com.bridgelabz.addressbookappspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AddressBookAppSpringApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book App");
        SpringApplication.run(AddressBookAppSpringApplication.class, args);
        System.out.println("Address Book Connected");
    }

}
