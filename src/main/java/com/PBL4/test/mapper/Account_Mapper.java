package com.PBL4.test.mapper;

import com.PBL4.test.entity.Account;

import com.PBL4.test.DTO.Account_Request;

public class Account_Mapper {
		
		public Account toAccount(Account_Request rq)
		{
			
			Account ac = new Account();
			System.out.println(rq);
			ac.setAddress(rq.getAddress());
			ac.setCid(rq.getCid());
			ac.setDob(rq.getDob());
			ac.setEmail(rq.getEmail());
			ac.setFirstName(rq.getFirstName());
			ac.setLastName(rq.getLastName());
			ac.setPassword(rq.getPassword());
			ac.setPhoneNumber(rq.getPhoneNumber());
			ac.setUsername(rq.getUsername());
			System.out.println(ac);
			return ac;
			
		}
}
