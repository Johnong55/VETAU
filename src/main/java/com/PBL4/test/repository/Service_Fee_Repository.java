package com.PBL4.test.repository;

import com.PBL4.test.entity.City;
import com.PBL4.test.entity.ServiceFee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Service_Fee_Repository extends JpaRepository<ServiceFee,String> {
    Boolean existsByServiceName(String serviceName);

    @EntityGraph(attributePaths = "priceList")
    Optional<ServiceFee> findByServiceFeeId(String serviceFeeId);

    @EntityGraph(attributePaths = "priceList")
    Optional<ServiceFee> findByServiceName(String serviceName);

    @Query("SELECT c FROM ServiceFee c ORDER BY c.serviceFeeId DESC LIMIT 1")
    ServiceFee findLastServiceFee();
}
