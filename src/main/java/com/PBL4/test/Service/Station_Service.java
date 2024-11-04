package com.PBL4.test.Service;

import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.Station;
import com.PBL4.test.repository.Station_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Station_Service {
    @Autowired
    Station_Repository station_repository;
    public Station CreateRequest(Station station ) {
        if(station_repository.existsById(station.getStationId()))
            throw new AppException(ErrorCode.STATION_EXISTED);
        else {
            return station_repository.save(station);
        }
    }
}
