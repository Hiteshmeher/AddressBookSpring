package com.bridgelabz.addressbookappspring.controller;

import com.bridgelabz.addressbookappspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookappspring.dto.ResponseDTO;
import com.bridgelabz.addressbookappspring.entity.AddressBookData;
import com.bridgelabz.addressbookappspring.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    /**
     * Getting all the Address Book Data from Database
     */
    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<List<AddressBookData>> getAddressBookData() {
        return addressBookService.getAddressBookData();
    }

    /**
     *
     * @param personId
     * Getting an AddressBook data by id from the Database
     */
    @GetMapping("/get/{personId}")
    public ResponseEntity<AddressBookData> getAddressBookData(@PathVariable("personId") int personId) {
        return addressBookService.getAddressBookDataById(personId);
    }



    /**
     *
     * @param addressBookDTO
     * Creating an AddressBook Data and save to the Database
     */
    @PostMapping("/create")
    public ResponseEntity<AddressBookData> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.createAddressBookData(addressBookDTO);
    }

    /**
     *
     * @param personId
     * @param addressBookDTO
     * Updating an AddressBook data by id from the Database
     */
    @PutMapping("/update/{personId}")
    public ResponseEntity<AddressBookData> updateAddressBookData(@PathVariable("personId") int personId,
                                                                 @Valid @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.updateAddressBookData(personId,addressBookDTO);
    }

    /**
     *
     * @param personId
     * Deleting an AddressBook Data from the Database
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("personId") int personId) {
        return addressBookService.deleteAddressBookData(personId);
    }

    /**
     *
     * Sorting AddressBook data from Database by City
     */
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortByCity(){
        List<AddressBookData>  addressBookData = null;
        addressBookData = addressBookService.sortContactsByCity();
        ResponseDTO responseDTO = new ResponseDTO("Sorted Contacts Details",addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     *
     * Sorting AddressBook data from Database by State
     */
    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortByState(){
        List<AddressBookData>  addressBookData = null;
        addressBookData = addressBookService.sortContactsByState();
        ResponseDTO responseDTO = new ResponseDTO("Sorted Contacts Details",addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}