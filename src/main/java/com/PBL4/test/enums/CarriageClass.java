package com.PBL4.test.enums;

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
}

