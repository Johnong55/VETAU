package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Seasonal_Rate_Request;
import com.PBL4.test.DTO.request.Service_Fee_Request;
import com.PBL4.test.DTO.response.Seasonal_Rate_Response;
import com.PBL4.test.DTO.response.Service_Fee_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.SeasonalRate;
import com.PBL4.test.entity.ServiceFee;
import com.PBL4.test.mapper.SeasonalRateMapper;
import com.PBL4.test.mapper.ServiceFeeMapper;
import com.PBL4.test.repository.Season_Rate_Repository;
import com.PBL4.test.repository.Service_Fee_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Seasonal_Rate_Service {
    @Autowired
    Season_Rate_Repository seasonRateRepository;
    @Autowired
    SeasonalRateMapper seasonalRateMapper;

    private String generateSeasonalRateID() {
        SeasonalRate lastSeasonalRate = seasonRateRepository.findLastSeasonalRate();
        if (lastSeasonalRate == null) {
            return "SR001";
        }
        String lastID = lastSeasonalRate.getSeasonalRateId();
        int lastNumber = Integer.parseInt(lastID.substring(2));
        int newNumber = lastNumber + 1;
        return String.format("SR%03d", newNumber);
    }

    public Seasonal_Rate_Response createSeasonalRate(Seasonal_Rate_Request request) {
        if (seasonRateRepository.existsBySeasonName(request.getSeasonName())) {
            throw new AppException(ErrorCode.SEASONAL_RATE_EXISTED);
        }
        SeasonalRate result = seasonalRateMapper.toSeasonalRate(request);
        result.setSeasonalRateId(generateSeasonalRateID());
        return seasonalRateMapper.toSeasonalRateResponse(seasonRateRepository.save(result));
    }

    public List<Seasonal_Rate_Response> findAll() {
        return seasonRateRepository.findAll().stream()
                .map(seasonalRateMapper::toSeasonalRateResponse)
                .collect(Collectors.toList());
    }

    public Seasonal_Rate_Response findByName(String seasonName) {
        SeasonalRate seasonalRate = seasonRateRepository.findBySeasonName(seasonName)
                .orElseThrow(() -> new AppException(ErrorCode.SEASONAL_RATE_NOT_EXISTED));
        return seasonalRateMapper.toSeasonalRateResponse(seasonalRate);
    }

    public Seasonal_Rate_Response findByID(String seasonalRateID) {
        SeasonalRate seasonalRate = seasonRateRepository.findBySeasonalRateId(seasonalRateID)
                .orElseThrow(() -> new AppException(ErrorCode.SEASONAL_RATE_NOT_EXISTED));
        return seasonalRateMapper.toSeasonalRateResponse(seasonalRate);
    }

    public Seasonal_Rate_Response updateSeasonalRate(String seasonalRateID, Seasonal_Rate_Request request) {
        SeasonalRate seasonalRate = seasonRateRepository.findBySeasonalRateId(seasonalRateID)
                .orElseThrow(() -> new AppException(ErrorCode.SEASONAL_RATE_NOT_EXISTED));
        seasonalRateMapper.updateSeasonalRate(seasonalRate, request);
        return seasonalRateMapper.toSeasonalRateResponse(seasonRateRepository.save(seasonalRate));
    }
    public void deteteSeasonalRate(String seasonalRateID) {
        seasonRateRepository.deleteById(seasonalRateID);
    }
}
