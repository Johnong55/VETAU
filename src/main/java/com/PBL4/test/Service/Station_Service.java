package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Station_Request;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.enums.ErrorCode;
import com.PBL4.test.entity.Station;
import com.PBL4.test.mapper.App_Mapper;
import com.PBL4.test.repository.Station_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Station_Service {
    @Autowired
    Station_Repository station_repository;

    public Station CreateRequest(Station_Request station ) {
        App_Mapper app_mapper = new App_Mapper();
        Station result = app_mapper.CreationtoStation(station);
        if(station_repository.findByStation_name(station.getStationName())==null)
            throw new AppException(ErrorCode.STATION_EXISTED);
        else {
            return station_repository.save(result);
        }
    }
    public List<Station> GetAllStation() {
        return station_repository.findAll();
    }
}
