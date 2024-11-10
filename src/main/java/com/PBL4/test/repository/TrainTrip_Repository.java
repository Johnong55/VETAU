package com.PBL4.test.repository;

import com.PBL4.test.entity.TrainTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainTrip_Repository extends JpaRepository<TrainTrip,String> {
}
