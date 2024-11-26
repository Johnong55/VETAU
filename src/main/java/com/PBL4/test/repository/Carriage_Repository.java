package com.PBL4.test.repository;

import com.PBL4.test.entity.Carriage;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Carriage_Repository extends JpaRepository<Carriage,String> {
    Boolean existsByCarriageNameAndTrain_TrainId(String carriageName, String trainId);

    @EntityGraph(attributePaths = "seats")
    Optional<Carriage> findByCarriageId(String carriageId);

    @EntityGraph(attributePaths = "seats")
    Optional<Carriage> findByCarriageName(String carriageName);

    @EntityGraph(attributePaths = "seats")
    List<Carriage> findByTrain_TrainId(String trainID);

    @Query("SELECT c FROM Carriage c ORDER BY c.carriageId DESC LIMIT 1")
    Carriage findLastCarriage();
}
