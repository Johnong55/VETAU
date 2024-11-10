package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.CityRequest;
import com.PBL4.test.DTO.response.CityResponse;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.Station;
import com.PBL4.test.mapper.CityMapper;
import com.PBL4.test.mapper.StationMapper;
import com.PBL4.test.repository.City_Repository;
import com.PBL4.test.repository.Station_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    StationMapper stationMapper;

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

    public CityResponse createCity(CityRequest request) {
        if (cityRepository.existsByCityName(request.getCityName())) {
            throw new AppException(ErrorCode.CITY_EXISTED);
        }
        City result = cityMapper.toCity(request);
        result.setCityID(generateCityID());
        return cityMapper.toCityResponse(cityRepository.save(result));
    }

    public List<CityResponse> findAll() {
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

    public CityResponse findByName(String cityName) {
        City city = cityRepository.findByCityName(cityName)
                .orElseThrow(() -> new AppException(ErrorCode.CITY_NOT_EXISTED));
        CityResponse cityResponse = cityMapper.toCityResponse(city);
        cityResponse.setStations(city.getStations().stream()
                .map(stationMapper::toStationResponse)
                .collect(Collectors.toList()));
        return cityResponse;
    }

    public CityResponse updateCity(String cityID, CityRequest request) {
        City city = cityRepository.findByCityID(cityID)
                .orElseThrow(() -> new RuntimeException("City not found"));
        cityMapper.updateCity(city, request);
        return cityMapper.toCityResponse(cityRepository.save(city));
    }

    public void deleteCity(String cityId) {
        cityRepository.deleteById(cityId);
    }
}
