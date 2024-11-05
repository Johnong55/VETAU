package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.Station;
import com.PBL4.test.mapper.App_Mapper;
import com.PBL4.test.repository.City_Repository;
import com.PBL4.test.repository.Station_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class City_Service {
    @Autowired
    City_Repository city_repository;
    @Autowired
    Station_Repository station_repository;
    public City CreateRequest(City_Request city) {
        if (city_repository.existsById(city.getCityID()))
        {
            throw new AppException(ErrorCode.CITY_EXISTED);
        }
        App_Mapper appMapper = new App_Mapper();
        City result = appMapper.CreationtoCity(city);
        return city_repository.save(result);
    }
    public List<City> findAll()
    {
        return city_repository.findAll();
    }
    public City addAStation(String cityID, String stationID) {
        City result = new City();
        Station station = station_repository.findById(stationID).orElseThrow(()-> new AppException(ErrorCode.STATION_NOT_EXISTED));
        if(city_repository.existsById(cityID))
        {
            result = city_repository.findById(cityID).orElseThrow(()-> new AppException(ErrorCode.CITY_NOT_EXISTED));
            result.addStation(station);

        }
        return city_repository.save(result);
    }
}
