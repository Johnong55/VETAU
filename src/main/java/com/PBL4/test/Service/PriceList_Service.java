package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.DTO.request.PriceList_Request;
import com.PBL4.test.DTO.response.City_Response;
import com.PBL4.test.DTO.response.PriceList_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.PriceList;
import com.PBL4.test.entity.Schedule;
import com.PBL4.test.entity.Station;
import com.PBL4.test.enums.CarriageClass;
import com.PBL4.test.repository.PriceList_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceList_Service {
    @Autowired
    PriceList_Repository priceListRepository;

    private String generatePriceListID(String priceListID) {
        PriceList lastPriceList = priceListRepository.findLastPriceList();
        if (lastPriceList == null) {
            return "PRL000001";
        }
        String lastID = lastPriceList.getPriceListID();
        int lastNumber = Integer.parseInt(lastID.substring(3));
        int newNumber = lastNumber + 1;
        return String.format("PRL%06d", newNumber);
    }
}