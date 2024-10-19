package com.PBL4.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PBL4.test.entity.Account;
import com.PBL4.test.mapper.Account_Mapper;
import com.PBL4.test.repository.Account_Repository;

import com.PBL4.test.DTO.Account_Request;

@Service
public class Account_Service {

	@Autowired
	private  Account_Repository ac;
	
	
	
	public Account CreateRequest(Account_Request rq)
	{
		
		Account account= new Account();
		Account_Mapper mapper = new Account_Mapper();
		
		account = mapper.toAccount(rq);
		
		
		return ac.save(account);
		
	}
	public List<Account> findall()
	{
		return ac.findAll();
	}
	public Account FindByEmail(String emaiString)
	{
		return ac.findAccountByEmail(emaiString);
	}

	
}
