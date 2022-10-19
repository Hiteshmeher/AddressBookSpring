package com.bridgelabz.addressbookappspring.service;

import com.bridgelabz.addressbookappspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookappspring.entity.AddressBookData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAddressBookService {
    ResponseEntity<List<AddressBookData>> getAddressBookData();
    ResponseEntity<AddressBookData> getAddressBookDataById(long personId);
    ResponseEntity<AddressBookData> createAddressBookData(AddressBookDTO addressBookDTO);
    ResponseEntity<AddressBookData> updateAddressBookData(long personId, AddressBookDTO addressBookDTO);

    ResponseEntity<String> deleteAddressBookData(long personId);
}