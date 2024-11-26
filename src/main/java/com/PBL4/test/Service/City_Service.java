package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.DTO.response.City_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.Station;
import com.PBL4.test.mapper.CityMapper;
import com.PBL4.test.mapper.Station_Mapper;
import com.PBL4.test.repository.City_Repository;
import com.PBL4.test.repository.Station_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class City_Service {
    @Autowired
    City_Repository cityRepository;
    @Autowired
    Station_Repository stationRepository;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    Station_Mapper stationMapper;

    private String generateCityID() {
        City lastCity = cityRepository.findLastCity();
        if (lastCity == null) {
            return "CT001";
        }
        String lastID = lastCity.getCityID();
        int lastNumber = Integer.parseInt(lastID.substring(2));
        int newNumber = lastNumber + 1;
        return String.format("CT%03d", newNumber);
    }

    public City_Response createCity(City_Request request) {
        if (cityRepository.existsByCityName(request.getCityName())) {
            throw new AppException(ErrorCode.CITY_EXISTED);
        }
        City result = cityMapper.toCity(request);
        result.setCityID(generateCityID());
        return cityMapper.toCityResponse(cityRepository.save(result));
    }

    public List<City_Response> findAll() {
        return cityRepository.findAll().stream()
                .map(cityMapper::toCityResponse)
                .collect(Collectors.toList());
    }

    public City addAStation(String cityID, String stationID) {
        City result = new City();
        Station station = stationRepository.findById(stationID).orElseThrow(() -> new AppException(ErrorCode.STATION_NOT_EXISTED));
        if (cityRepository.existsById(cityID)) {
            result = cityRepository.findById(cityID).orElseThrow(() -> new AppException(ErrorCode.CITY_NOT_EXISTED));
            result.addStation(station);

        }
        return cityRepository.save(result);
    }

    public City_Response findByName(String cityName) {
        City city = cityRepository.findByCityName(cityName)
                .orElseThrow(() -> new AppException(ErrorCode.CITY_NOT_EXISTED));
        return cityMapper.toCityResponse(city);
    }

    public City_Response findByID(String cityID) {
        City city = cityRepository.findByCityID(cityID)
                .orElseThrow(() -> new AppException(ErrorCode.CITY_NOT_EXISTED));

        return cityMapper.toCityResponse(city);
    }

    public City_Response updateCity(String cityID, City_Request request) {
        City city = cityRepository.findByCityID(cityID)
                .orElseThrow(() -> new RuntimeException("City not found"));
        cityMapper.updateCity(city, request);
        return cityMapper.toCityResponse(cityRepository.save(city));
    }

    public void deleteCity(String cityId) {
        cityRepository.deleteById(cityId);
    }
}
