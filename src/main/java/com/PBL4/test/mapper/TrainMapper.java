package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.Train_Request;
import com.PBL4.test.DTO.response.Train_Response;
import com.PBL4.test.entity.Train;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = Station_Mapper.class)
public interface TrainMapper {
    Train toTrain(Train_Request request);

    Train_Response toTrainResponse(Train train);

    void updateTrain(@MappingTarget Train train, Train_Request request);
}
