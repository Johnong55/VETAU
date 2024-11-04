package com.PBL4.test.DTO.request;

import java.util.List;

public class City_Request {
    private String cityID;
    private String cityName;
    private List<String> stationIds; // List of station IDs associated with the city

    // Constructors
    public City_Request() {
        super();
    }

    public City_Request(String cityID, String cityName, List<String> stationIds) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.stationIds = stationIds;
    }

    // Getters and Setters
    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getStationIds() {
        return stationIds;
    }

    public void setStationIds(List<String> stationIds) {
        this.stationIds = stationIds;
    }
}
