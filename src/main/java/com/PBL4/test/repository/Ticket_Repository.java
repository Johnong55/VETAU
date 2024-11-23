package com.PBL4.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Ticket;

import java.util.Optional;

@Repository
public interface Ticket_Repository extends JpaRepository<Ticket,String> {

	@Query("select  a from Ticket a " +
			"where a.sku_TK = :sku_TK")
	Optional<Ticket> findBySku_TK(String sku_TK);
}
