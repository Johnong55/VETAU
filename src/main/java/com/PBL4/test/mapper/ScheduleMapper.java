package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.Schedule_Request;
import com.PBL4.test.DTO.response.Schedule_Response;
import com.PBL4.test.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = Station_Mapper.class)
public interface ScheduleMapper {
    @Mapping(target = "departureStation.stationId", source = "departureStationId")
    @Mapping(target = "arrivalStation.stationId", source = "arrivalStationId")
    @Mapping(target = "train.trainId", source = "trainId")
    Schedule toSchedule(Schedule_Request request);

    @Mapping(target = "departureStationName", source = "departureStation.stationName")
    @Mapping(target = "arrivalStationName", source = "arrivalStation.stationName")
    @Mapping(target = "trainId", source = "train.trainId")
    Schedule_Response toScheduleResponse(Schedule schedule);

    void updateSchedule(@MappingTarget Schedule schedule, Schedule_Request request);

}
