package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.Station_Request;
import com.PBL4.test.DTO.request.Train_Request;
import com.PBL4.test.DTO.response.Station_Response;
import com.PBL4.test.entity.Station;
import com.PBL4.test.entity.Train;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface Station_Mapper {

    @Mapping(source = "city.cityName", target = "cityName")
    Station_Response toStationResponse(Station station);
    Station toStation(Station_Request request);
    @Mapping(source = "cityID", target = "city.cityID")
    void updateStation(@MappingTarget Station station, Station_Request request);
}
