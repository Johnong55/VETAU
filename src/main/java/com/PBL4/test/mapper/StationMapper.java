package com.PBL4.test.mapper;

import com.PBL4.test.DTO.response.StationResponse;
import com.PBL4.test.entity.Station;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper {
    StationResponse toStationResponse(Station station);
}
