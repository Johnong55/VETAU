package com.PBL4.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Account;

import java.util.Optional;
@Repository
public interface Account_Repository extends JpaRepository<Account, String> {

    @Query("SELECT a FROM Account a WHERE a.email = :username OR a.username = :username")
    Optional<Account> existsByEmailOrUsername(@Param("username") String username);

}
