package com.PBL4.test.Service;

import java.util.List;

import com.PBL4.test.DTO.request.Account_CreationRequest;
import com.PBL4.test.DTO.request.Account_UpdateRequest;
import com.PBL4.test.DTO.response.Account_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.City;
import com.PBL4.test.enums.Role;
import com.PBL4.test.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.PBL4.test.entity.Account;
import com.PBL4.test.repository.Account_Repository;

import com.PBL4.test.DTO.request.Account_CreationRequest;


@Service
@RequiredArgsConstructor
public class Account_Service {

    @Autowired
    private Account_Repository accountRepository;
    @Autowired
    private AccountMapper accountMapper;

    public Account_Response createAccount(Account_CreationRequest request) {

        if (accountRepository.existsByUsername(request.getUsername())
                || accountRepository.existsByEmail(request.getEmail())
                || accountRepository.existsByCid(request.getCid())) {
            throw new AppException(ErrorCode.ACCOUNT_EXISTED);
        }
        Account account = accountMapper.toAccount(request);
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        account.setPassword(encoder.encode(request.getPassword()));
        account.setRole(Role.USER.name());
        account.setId(generateCityID());
        return accountMapper.toAccountResponse(accountRepository.save(account));
    }

    public Account_Response updateAccount(String AccountID, Account_UpdateRequest request) {
        if(accountRepository.existsByEmail(request.getEmail())){
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        Account account = accountRepository.findById(AccountID)
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED));
        accountMapper.updateAccount(account, request);
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        account.setPassword(encoder.encode(request.getPassword()));
        return accountMapper.toAccountResponse(accountRepository.save(account));
    }

    public List<Account_Response> findall() {
        return accountRepository.findAll().stream()
                .map(accountMapper::toAccountResponse)
                .toList();
    }

    public Account_Response getByAccountID(String id) {
        return accountMapper.toAccountResponse(accountRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED)));
    }

    public Account_Response getByUsername(String username) {
        return accountMapper.toAccountResponse(accountRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED)));
    }

    public Account_Response getByEmail(String email) {
        return accountMapper.toAccountResponse(accountRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED)));
    }


    public void deleteAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }

    private String generateCityID() {
        Account lastAccount = accountRepository.findLastAccount();
        if (lastAccount == null) {
            return "AC001";
        }
        String lastID = lastAccount.getId();
        int lastNumber = Integer.parseInt(lastID.substring(2));
        int newNumber = lastNumber + 1;
        return String.format("AC%03d", newNumber);
    }

}
