package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Station_Request;
import com.PBL4.test.DTO.request.Train_Request;
import com.PBL4.test.DTO.response.Station_Response;
import com.PBL4.test.DTO.response.Train_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.Station;
import com.PBL4.test.entity.Train;
import com.PBL4.test.mapper.Station_Mapper;
import com.PBL4.test.repository.City_Repository;
import com.PBL4.test.repository.Station_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Station_Service {
    @Autowired
    City_Repository city_Repository;
    @Autowired
    Station_Repository station_repository;

    @Autowired
    Station_Mapper station_mapper;

    public Station_Response createStation(Station_Request request) {
        City city = city_Repository.findById(request.getCityID())
                .orElseThrow(() -> new AppException(ErrorCode.CITY_NOT_EXISTED));

        if (station_repository.existsByStationName(request.getStationName())) {
            throw new AppException(ErrorCode.STATION_EXISTED);
        }
        Station result = station_mapper.toStation(request);
        result.setCity(city);
        result.setStationId(generateCityID(result.getCity().getCityID()));
        return station_mapper.toStationResponse(station_repository.save(result));
    }

    public Station_Response findByID(String stationID) {
        Station station = station_repository.findByStationId(stationID)
                .orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED));
        return station_mapper.toStationResponse(station);
    }

    public Station_Response findByName(String stationName) {
        Station station = station_repository.findByStationName(stationName)
                .orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED));
        return station_mapper.toStationResponse(station);
    }

    public Station_Response updateStation(String stationID, Station_Request request) {
        City city = city_Repository.findById(request.getCityID())
                .orElseThrow(() -> new AppException(ErrorCode.CITY_NOT_EXISTED));
        Station station = station_repository.findByStationId(stationID)
                .orElseThrow(() -> new RuntimeException("City not found"));
        station.setCity(city);
        station_mapper.updateStation(station, request);
        return station_mapper.toStationResponse(station_repository.save(station));
    }

    public void deleteStation(String stationID) {
        station_repository.deleteById(stationID);
    }


    private String generateCityID(String CityID) {
        Station lastStation = station_repository.findLastStation(CityID);
        if (lastStation == null) {
            return CityID+"001";
        }
        String lastID = lastStation.getStationId();
        int lastNumber = Integer.parseInt(lastID.substring(2));
        int newNumber = lastNumber + 1;
        return String.format("CT%03d", newNumber);
    }

    public List<Station_Response> getAll() {
        return station_repository.findAll().stream()
                .map(station_mapper::toStationResponse)
                .collect(Collectors.toList());
    }

}
