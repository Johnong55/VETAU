package com.PBL4.test.DTO.request;

import java.util.List;

public class Train_Request {
    private String trainName;
    private List<String> trainTripIds;  // Chứa các ID của trainTrip để liên kết
    private List<String> carriageIds;   // Chứa các ID của carriage để liên kết
    private List<String> scheduleIds;   // Chứa các ID của schedule để liên kết
    private List<String> priceListIds;  // Chứa các ID của priceList để liên kết

    // Getter và Setter
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<String> getTrainTripIds() {
        return trainTripIds;
    }

    public void setTrainTripIds(List<String> trainTripIds) {
        this.trainTripIds = trainTripIds;
    }

    public List<String> getCarriageIds() {
        return carriageIds;
    }

    public void setCarriageIds(List<String> carriageIds) {
        this.carriageIds = carriageIds;
    }

    public List<String> getScheduleIds() {
        return scheduleIds;
    }

    public void setScheduleIds(List<String> scheduleIds) {
        this.scheduleIds = scheduleIds;
    }

    public List<String> getPriceListIds() {
        return priceListIds;
    }

    public void setPriceListIds(List<String> priceListIds) {
        this.priceListIds = priceListIds;
    }
}
