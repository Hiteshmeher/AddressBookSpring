package com.bridgelabz.addressbookappspring.repository;

import com.bridgelabz.addressbookappspring.entity.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData,Long> {
}
