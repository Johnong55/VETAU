package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.PriceList_Request;
import com.PBL4.test.DTO.response.PriceList_Response;
import com.PBL4.test.entity.PriceList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceListMapper {

    @Mapping(source = "departureStation.stationName", target = "departureStationName")
    @Mapping(source = "arrivalStation.stationName", target = "arrivalStationName")
    @Mapping(source = "seasonalRate.seasonName", target = "seasonName")
    @Mapping(source = "seasonalRate.rateMultiplier", target = "rateMultiplier")
    PriceList_Response toPriceListResponse(PriceList priceList);

    PriceList toPriceList(PriceList_Request request);

//    void updatePriceList(@MappingTarget PriceList priceList, PriceList_Request request);
}
