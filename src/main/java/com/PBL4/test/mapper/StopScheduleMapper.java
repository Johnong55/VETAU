package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.StopSchedule_Request;
import com.PBL4.test.DTO.response.Stop_Schedule_Response;
import com.PBL4.test.entity.StopSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StopScheduleMapper {

    @Mapping(target = "stopStation.stationId", source = "stopStationId") // Ánh xạ ID ga dừng
    @Mapping(target = "schedule.scheduleId", source = "scheduleId")     // Ánh xạ ID lịch trình
    StopSchedule toEntity(StopSchedule_Request request);

    @Mapping(target = "stopStationName", source = "stopStation.stationName")
    @Mapping(target = "arrivalStationName", source = "arrivalStation.stationName")
    @Mapping(target = "departureStationName", source = "departureStation.stationName")
    @Mapping(target = "arrivalTime", source = "arrivalTime")
    @Mapping(target = "scheduleId", source = "schedule.scheduleId")
    @Mapping(target = "orderedSeat", source = "orderedSeat")
    Stop_Schedule_Response toResponse(StopSchedule stopSchedule);

    @Mapping(target = "stopStation.stationId", source = "stopStationId")
    @Mapping(target = "schedule.scheduleId", source = "scheduleId")
    void updateEntity(@MappingTarget StopSchedule stopSchedule, StopSchedule_Request request);
}
