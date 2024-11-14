package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.DTO.request.Service_Fee_Request;
import com.PBL4.test.DTO.response.City_Response;
import com.PBL4.test.DTO.response.Service_Fee_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.ServiceFee;
import com.PBL4.test.entity.Station;
import com.PBL4.test.mapper.CityMapper;
import com.PBL4.test.mapper.ServiceFeeMapper;
import com.PBL4.test.mapper.Station_Mapper;
import com.PBL4.test.repository.City_Repository;
import com.PBL4.test.repository.Service_Fee_Repository;
import com.PBL4.test.repository.Station_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class Service_Fee_Service {
    @Autowired
    Service_Fee_Repository serviceFeeRepository;
    @Autowired
    ServiceFeeMapper serviceFeeMapper;

    private String generateServiceFeeID() {
        ServiceFee lastServiceFee = serviceFeeRepository.findLastServiceFee();
        if (lastServiceFee == null) {
            return "SF0001";
        }
        String lastID = lastServiceFee.getServiceFeeId();
        int lastNumber = Integer.parseInt(lastID.substring(2));
        int newNumber = lastNumber + 1;
        return String.format("SF%04d", newNumber);
    }

    public Service_Fee_Response createServiceFee(Service_Fee_Request request) {
        if (serviceFeeRepository.existsByServiceName(request.getServiceName())) {
            throw new AppException(ErrorCode.SERVICE_FEE_EXISTED);
        }
        ServiceFee result = serviceFeeMapper.toServiceFee(request);
        result.setServiceFeeId(generateServiceFeeID());
        return serviceFeeMapper.toServiceFeeResponse(serviceFeeRepository.save(result));
    }

    public List<Service_Fee_Response> findAll() {
        return serviceFeeRepository.findAll().stream()
                .map(serviceFeeMapper::toServiceFeeResponse)
                .collect(Collectors.toList());
    }

    public Service_Fee_Response findByName(String serviceName) {
        ServiceFee serviceFee = serviceFeeRepository.findByServiceName(serviceName)
                .orElseThrow(() -> new AppException(ErrorCode.SERVICE_FEE_NOT_EXISTED));
        return serviceFeeMapper.toServiceFeeResponse(serviceFee);
    }

    public Service_Fee_Response findByID(String serviceFeeID) {
        ServiceFee serviceFee = serviceFeeRepository.findByServiceFeeId(serviceFeeID)
                .orElseThrow(() -> new AppException(ErrorCode.SERVICE_FEE_NOT_EXISTED));
        return serviceFeeMapper.toServiceFeeResponse(serviceFee);
    }

    public Service_Fee_Response updateServiceFee(String serviceFeeID, Service_Fee_Request request) {
        ServiceFee serviceFee = serviceFeeRepository.findByServiceFeeId(serviceFeeID)
                .orElseThrow(() -> new AppException(ErrorCode.SERVICE_FEE_NOT_EXISTED));
        serviceFeeMapper.updateServiceFee(serviceFee, request);
        return serviceFeeMapper.toServiceFeeResponse(serviceFeeRepository.save(serviceFee));
    }

    public void deleteServiceFee(String serviceFeeID) {
        serviceFeeRepository.deleteById(serviceFeeID);
    }
}
