package com.PBL4.test.Configuration;
import com.PBL4.test.entity.Account;
import com.PBL4.test.enums.Role;
import com.PBL4.test.repository.Account_Repository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(Account_Repository accountRepository) {
        return args -> {
            if(accountRepository.findByUsername("admin").isEmpty()){
                String role = Role.ADMIN.name();

                Account account = Account.builder()
                        .username("admin")
                        .id("AC001")
                        .password(passwordEncoder.encode("12345678"))
                        .role(role)
                        .email("admin@admin.com")
                        .cid("000000000000")
                        .build();

                accountRepository.save(account);
                log.warn("admin user has been created with default password: admin, please change it");
            }
        };
    };
}
