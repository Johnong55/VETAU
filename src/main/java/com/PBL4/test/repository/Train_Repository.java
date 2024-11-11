package com.PBL4.test.repository;

import com.PBL4.test.entity.City;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PBL4.test.entity.Train;

import java.util.Optional;

@Repository
public interface Train_Repository extends JpaRepository<Train, String> {
    @Query("SELECT c FROM Train c ORDER BY c.trainId DESC LIMIT 1")
    Train findLastTrain();

    Optional<Train> findByTrainName(String trainName);

    Optional<Train> findByTrainId(String trainId);

    Boolean existsByTrainName(String trainName);
}
