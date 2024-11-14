package com.PBL4.test.repository;

import com.PBL4.test.entity.City;
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

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByCid(String cid);
    Optional<Account> findByEmail(String email);
    Optional<Account> findByUsername(String username);
    Optional<Account> findByUsernameAndPassword(String username, String password);

    @Query("SELECT c FROM Account c ORDER BY c.id DESC LIMIT 1")
    Account findLastAccount();
}
