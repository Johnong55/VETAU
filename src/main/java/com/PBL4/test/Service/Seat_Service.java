package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.City_Request;
import com.PBL4.test.DTO.request.Seat_Request;
import com.PBL4.test.DTO.request.Seat_UpdateRequest;
import com.PBL4.test.DTO.request.Station_Request;
import com.PBL4.test.DTO.response.City_Response;
import com.PBL4.test.DTO.response.Seat_Response;
import com.PBL4.test.DTO.response.Station_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.entity.Carriage;
import com.PBL4.test.entity.City;
import com.PBL4.test.entity.Seat;
import com.PBL4.test.entity.Station;
import com.PBL4.test.mapper.CityMapper;
import com.PBL4.test.mapper.SeatMapper;
import com.PBL4.test.mapper.Station_Mapper;
import com.PBL4.test.repository.Carriage_Repository;
import com.PBL4.test.repository.City_Repository;
import com.PBL4.test.repository.Seat_Repository;
import com.PBL4.test.repository.Station_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class Seat_Service {
    @Autowired
    Carriage_Repository carriage_Repository;
    @Autowired
    Seat_Repository seat_Repository;
    @Autowired
    SeatMapper seatMapper;

    @Transactional
    public List<Seat_Response> createSeats(Seat_Request request) {
        Carriage carriage = carriage_Repository.findById(request.getCarriageID())
                .orElseThrow(() -> new AppException(ErrorCode.CARRIAGE_NOT_EXISTED));

        int seatCount = carriage.getSeatCount();
        String carriageIdSuffix = carriage.getCarriageId().substring(carriage.getCarriageId().length() - 3);

        List<Seat> seats = generateSeats(request, carriage, carriageIdSuffix, seatCount);
        seat_Repository.saveAll(seats);

        return seats.stream()
                .map(seatMapper::toSeatResponse)
                .collect(Collectors.toList());
    }

    private List<Seat> generateSeats(Seat_Request request, Carriage carriage, String carriageIdSuffix, int seatCount) {
        return java.util.stream.IntStream.range(1, seatCount + 1)
                .mapToObj(i -> {
                    String seatId = "SCR" + carriageIdSuffix + String.format("%03d", i);
                    String sku = "SSKU" + carriageIdSuffix + String.format("%03d", i);
                    String seatName = "Ghế " + String.format("%03d", i);
                    Seat seat = new Seat();
                    seat.setSeatId(seatId);
                    seat.setSku(sku);
                    seat.setSeatName(seatName);
                    seat.setCarriage(carriage);
                    seat.setSituation(false);
                    seat.setSeatType(carriage.getCarriageClass().getSeatType());

                    return seat;
                })
                .collect(Collectors.toList());
    }

    public List<Seat_Response> getAll(){
        return seat_Repository.findAll().stream()
                .map(seatMapper::toSeatResponse)
                .collect(Collectors.toList());
    }

    public void deleteSeat(String seatID){
        seat_Repository.deleteById(seatID);
    }
    @Transactional
    public void deleteByCarriageID(String carriageID){
        List<Seat> seats = seat_Repository.findByCarriage_CarriageId(carriageID);
        if (seats.isEmpty()) {
            throw new AppException(ErrorCode.SEATS_WITH_CARRIAGEID_NOT_EXISTED);
        }
        seat_Repository.deleteByCarriage_CarriageId(carriageID);
    }

    public Seat_Response updateSituation(String seatID, Seat_UpdateRequest request){
        Seat seat = seat_Repository.findBySeatId(seatID)
                .orElseThrow(() -> new AppException(ErrorCode.SEAT_NOT_EXISTED));
        seat.setSituation(request.isSituation());
        return seatMapper.toSeatResponse(seat_Repository.save(seat));
    }

    public Seat_Response findByID(String seatID){
        Seat seat = seat_Repository.findBySeatId(seatID)
                .orElseThrow(()->new AppException(ErrorCode.SEAT_NOT_EXISTED));
        return seatMapper.toSeatResponse(seat);
    }
    public Seat_Response findBySku(String sku){
        Seat seat = seat_Repository.findBySku(sku)
                .orElseThrow(()->new AppException(ErrorCode.SEAT_NOT_EXISTED));
        return seatMapper.toSeatResponse(seat);
    }

    public List<Seat_Response> findByCarriageID(String carriageID){
        List<Seat> seats = seat_Repository.findByCarriage_CarriageId(carriageID);
        if (seats.isEmpty()) {
            throw new AppException(ErrorCode.SEATS_WITH_CARRIAGEID_NOT_EXISTED);
        }
        return seats.stream()
                .map(seatMapper::toSeatResponse)
                .collect(Collectors.toList());
    }
}
