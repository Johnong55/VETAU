package com.PBL4.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Ticket;

@Repository
public interface Ticket_Repository extends JpaRepository<Ticket,String> {
	
}
