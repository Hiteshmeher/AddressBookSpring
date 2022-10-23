package com.bridgelabz.addressbookappspring.service;

import com.bridgelabz.addressbookappspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookappspring.entity.AddressBookData;
import com.bridgelabz.addressbookappspring.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookServiceImpl implements IAddressBookService{
    List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Autowired
    private AddressBookRepository addressBookRepo;

    /**
     * Method to get all the AddressBook data from Database
     */
    @Override
    public ResponseEntity<List<AddressBookData>> getAddressBookData() {
        return new ResponseEntity<>(addressBookRepo.findAll(), HttpStatus.OK);
    }

    /**
     *
     * @param personId
     * Method to get an AddressBook Data using id from the Database
     */
    @Override
    public ResponseEntity<AddressBookData> getAddressBookDataById(long personId) {
        AddressBookData addressBookData = addressBookRepo.findById(personId).orElse(null);
        return new ResponseEntity<>(addressBookData,HttpStatus.OK);
    }

    /**
     *
     * @param addressBookDTO
     * Method to Create an AddressBook Data to the Database
     */
    @Override
    public ResponseEntity<AddressBookData> createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData =new AddressBookData(addressBookDTO);
        addressBookRepo.save(addressBookData);
        return new ResponseEntity<>(addressBookData,HttpStatus.OK);
    }

    /**
     *
     * @param personId
     * @param addressBookDTO
     * Method to update an AddressBook Data from Database
     */
    @Override
    public ResponseEntity<AddressBookData> updateAddressBookData(long personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBook = addressBookRepo.findById(personId).orElse(null);
        if (addressBook != null){
            addressBook.setFirstName(addressBookDTO.getFirstName());
            addressBook.setLastName(addressBookDTO.getLastName());
            addressBook.setContactNo(addressBookDTO.getContactNo());
            addressBook.setEmail(addressBookDTO.getEmail());
            addressBook.setAddress(addressBookDTO.getAddress());
            addressBook.setCity(addressBookDTO.getCity());
            addressBook.setState(addressBookDTO.getState());
            addressBook.setPinCode(addressBookDTO.getPinCode());
            addressBookRepo.save(addressBook);
        }
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    /**
     *
     * @param personId
     * Method to Delete an AddressBook Data from the Database
     */
    @Override
    public ResponseEntity<String> deleteAddressBookData(long personId) {
        addressBookRepo.deleteById(personId);
        return new ResponseEntity<>("Deleted address book data for id : "+personId, HttpStatus.OK);
    }

    @Override
    public List<AddressBookData> sortContactsByCity() {
        return addressBookRepo.sortByCity();
    }

    @Override
    public List<AddressBookData> sortContactsByState() {
        return addressBookRepo.sortByState();
    }
}
