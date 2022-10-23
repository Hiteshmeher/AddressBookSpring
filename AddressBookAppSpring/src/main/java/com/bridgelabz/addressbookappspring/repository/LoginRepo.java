package com.bridgelabz.addressbookappspring.repository;

import com.bridgelabz.addressbookappspring.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<UserData, Integer> {
    @Query(value = "select * from user_data where user_name = :userName and password = :password",nativeQuery = true)
    UserData checkLogin(String userName, String password);
}
