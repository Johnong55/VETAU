package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.Seat_Request;
import com.PBL4.test.DTO.request.Seat_UpdateRequest;
import com.PBL4.test.DTO.request.Station_Request;
import com.PBL4.test.DTO.response.Seat_Response;
import com.PBL4.test.entity.Seat;
import com.PBL4.test.entity.Station;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = Station_Mapper.class)
public interface SeatMapper {
    Seat toSeat(Seat_Request request);

    @Mapping(source = "carriage.carriageName", target = "carriageName")
    Seat_Response toSeatResponse(Seat seat);

    void updateSeat(@MappingTarget Seat seat, Seat_UpdateRequest request);
}
