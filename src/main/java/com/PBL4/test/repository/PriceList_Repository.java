package com.PBL4.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.PriceList;

@Repository
public interface PriceList_Repository extends JpaRepository<PriceList, String> {

}
