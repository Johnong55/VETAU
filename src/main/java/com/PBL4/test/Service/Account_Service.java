package com.PBL4.test.Service;

import java.util.List;
import com.PBL4.test.DTO.request.Account_UpdateRequest;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.PBL4.test.entity.Account;
import com.PBL4.test.mapper.App_Mapper;
import com.PBL4.test.repository.Account_Repository;

import com.PBL4.test.DTO.request.Account_Request;


@Service
public class Account_Service {

	@Autowired
	private  Account_Repository ac;
	
	
	
	public Account CreateRequest(Account_Request rq)
	{
		
		Account account= new Account();
		if(ac.existsByEmailOrUsername(rq.getUsername())!= null)
		{
			throw new AppException(ErrorCode.ACCOUNT_EXISTED);
		}
		App_Mapper mapper = new App_Mapper();

		account = mapper.CreationtoAccount(rq);
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);
		account.setPassword(encoder.encode(rq.getPassword()));


		return ac.save(account);
		
	}
	public Account UpdateRequest(Account_UpdateRequest rq,String AccountId)
	{
		Account account = getAccount(AccountId);
		App_Mapper mapper = new App_Mapper();
		account = mapper.UpdateToAccount(rq,account);

		return ac.save(account);
	}
	public List<Account> findall()
	{
		return ac.findAll();
	}

	public Account getAccount(String id)
	{
		return ac.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}
	
}
