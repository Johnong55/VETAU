package com.PBL4.test.Config;

import com.PBL4.test.entity.Account;
import com.PBL4.test.enums.Role;
import com.PBL4.test.repository.Account_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
public class ApplicationInitConfig {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Bean
    ApplicationRunner applicationRunner(Account_Repository account_Repository   )
    {
        return args -> {
            if(account_Repository.existsByEmailOrUsername("admin").isEmpty()){
                var roles = new HashSet<String>();
                roles.add(Role.ADMIN.name());
                Account account = new Account();
                account.setUsername("admin");
                account.setEmail("admin@admin.com");
                account.setPassword(passwordEncoder.encode("admin"));  // Encode the password
                account.setRoles(roles);
                account_Repository.save(account);
            }
        };
    }
}
