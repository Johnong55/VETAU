package com.PBL4.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Train;

@Repository
public interface Train_Repository extends JpaRepository<Train, String> {

}
