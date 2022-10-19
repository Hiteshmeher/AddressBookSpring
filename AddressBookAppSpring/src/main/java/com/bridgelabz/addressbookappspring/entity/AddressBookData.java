package com.bridgelabz.addressbookappspring.entity;

import com.bridgelabz.addressbookappspring.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "addressbook_table")
public class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pinCode;

    public AddressBookData(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.contactNo = addressBookDTO.getContactNo();
        this.email = addressBookDTO.getEmail();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.pinCode = addressBookDTO.getPinCode();
    }
}