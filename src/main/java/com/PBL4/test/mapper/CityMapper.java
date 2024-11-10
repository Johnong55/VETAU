package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.CityRequest;
import com.PBL4.test.DTO.response.CityResponse;
import com.PBL4.test.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = StationMapper.class)
public interface CityMapper {
    City toCity(CityRequest request);

    @Mapping(target = "stations", source = "stations")
    CityResponse toCityResponse(City city);

    void updateCity(@MappingTarget City city, CityRequest request);
}
