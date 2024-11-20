package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.DTO.response.City_Response;
import com.PBL4.test.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = Station_Mapper.class)
public interface CityMapper {
    City toCity(City_Request request);

    City_Response toCityResponse(City city);

    void updateCity(@MappingTarget City city, City_Request request);
}
