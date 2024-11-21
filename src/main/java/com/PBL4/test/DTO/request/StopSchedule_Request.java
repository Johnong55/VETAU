package com.PBL4.test.DTO.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StopSchedule_Request implements Comparable<StopSchedule_Request> {
    String stopScheduleId;
    double time;
    String scheduleId;
    @Override
    public int compareTo(StopSchedule_Request object)
    {
        return Double.compare(this.time,object.time);
    }
}
