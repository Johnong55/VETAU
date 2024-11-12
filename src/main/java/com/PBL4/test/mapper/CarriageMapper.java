package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.Carriage_Request;
import com.PBL4.test.DTO.response.Carriage_Response;
import com.PBL4.test.entity.Carriage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = Station_Mapper.class)
public interface CarriageMapper {
    Carriage toCarriage(Carriage_Request request);

    Carriage_Response toCarriageResponse(Carriage carriage);

    void updateCarriage(@MappingTarget Carriage carriage, Carriage_Request request);

}
