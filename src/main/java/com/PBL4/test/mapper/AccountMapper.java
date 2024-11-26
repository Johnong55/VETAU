package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.Account_CreationRequest;
import com.PBL4.test.DTO.request.Account_UpdateRequest;
import com.PBL4.test.DTO.response.Account_Response;
import com.PBL4.test.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toAccount(Account_CreationRequest account);
    Account_Response toAccountResponse(Account account);
    void updateAccount(@MappingTarget Account account, Account_UpdateRequest account_update);
}
