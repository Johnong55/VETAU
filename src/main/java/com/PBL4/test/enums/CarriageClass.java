package com.PBL4.test.enums;

import java.util.Arrays;

public enum CarriageClass {
    FIRST_CLASS("Phòng nằm"),
    SECOND_CLASS("Giường nằm"),
    DOUBLE_NORMAL_CLASS("Ghế đôi"),
    SINGLE_NORMAL_CLASS("Ghế đơn");

    private final String seatType;

    CarriageClass(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatType() {
        return seatType;
    }
    public static CarriageClass fromString(String seatType) {
        return Arrays.stream(CarriageClass.values())
                .filter(carriageClass -> carriageClass.seatType.equalsIgnoreCase(seatType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant for seatType: " + seatType));
    }
}

