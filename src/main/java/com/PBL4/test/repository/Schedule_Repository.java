package com.PBL4.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Schedule;

@Repository
public interface Schedule_Repository extends JpaRepository<Schedule, String > {

}
