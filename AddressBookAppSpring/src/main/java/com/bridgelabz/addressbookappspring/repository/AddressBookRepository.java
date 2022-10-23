package com.bridgelabz.addressbookappspring.repository;

import com.bridgelabz.addressbookappspring.entity.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData,Long> {
    @Query(value = "SELECT state FROM addressbook_table order by state",nativeQuery = true)
    List<AddressBookData> sortByCity();

    @Query(value = "select * from addressbook_table order by state ",nativeQuery = true)
    List<AddressBookData> sortByState();
}
