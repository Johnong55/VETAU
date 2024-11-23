package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.Service_Fee_Request;
import com.PBL4.test.DTO.response.Service_Fee_Response;
import com.PBL4.test.entity.ServiceFee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = Station_Mapper.class)
public interface ServiceFeeMapper {
    ServiceFee toServiceFee(Service_Fee_Request request);
    Service_Fee_Response toServiceFeeResponse(ServiceFee serviceFee);
    void updateServiceFee(@MappingTarget ServiceFee serviceFee, Service_Fee_Request request);
}
