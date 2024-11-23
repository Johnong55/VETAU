package com.PBL4.test.mapper;

import com.PBL4.test.DTO.request.Seasonal_Rate_Request;
import com.PBL4.test.DTO.response.Seasonal_Rate_Response;
import com.PBL4.test.entity.SeasonalRate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = Station_Mapper.class)
public interface SeasonalRateMapper {
    SeasonalRate toSeasonalRate(Seasonal_Rate_Request request);
    Seasonal_Rate_Response toSeasonalRateResponse(SeasonalRate seasonalRate);

    void updateSeasonalRate(@MappingTarget SeasonalRate seasonalRate, Seasonal_Rate_Request request);
}
