package com.PBL4.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Account;

@Repository
public interface Account_Repository extends JpaRepository<Account,String>{	
    @Query("SELECT a FROM Account a WHERE a.email = :email ")
    Account findAccountByEmail(@Param("email") String email);
}
