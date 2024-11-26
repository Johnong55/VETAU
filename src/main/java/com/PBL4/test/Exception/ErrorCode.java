package com.PBL4.test.Exception;

public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    ACCOUNT_EXISTED(1002, "Account already existed"),
    ACCOUNT_NOT_EXISTED(1003, "Account not existed"),
    INVALID_PASSWORD(1004, "Invalid password"),
    INVALID_KEY(1005, "Invalid key"),
    UNAUTHENTICATED(1006,"Unauthenticated"),
    SCHEDULE_NOT_EXISTED(1007,"Schedule not existed"),
    TrainTrip_NOTEXISTED(1008,"Train not existed"),
    CITY_EXISTED(1009,"City existed"),
    CITY_NOT_EXISTED(1010,"City not existed"),
    STATION_EXISTED(1011,"Station existed"),
    STATION_NOT_EXISTED(1012,"Station not existed"),
    TRAIN_EXISTED(1013,"Train existed"),
    TRAIN_NOT_EXISTED(1014,"Train not existed"),
    EMAIL_EXISTED(1015,"Email existed"),
    CARRIAGE_EXISTED(1016,"Carriage existed"),
    CARRIAGE_NOT_EXISTED(1017,"Carriage not existed"),
    SEAT_ID_MISSING(1018,"Seat id missing"),
    SEAT_NOT_EXISTED(1019,"Seat not existed"),
    SEATS_WITH_CARRIAGEID_NOT_EXISTED(1020,"Seats with carriageID not existed"),
    SERVICE_FEE_EXISTED(1021,"Service fee existed"),
    SERVICE_FEE_NOT_EXISTED(1022,"Service fee not existed"),
    SEASONAL_RATE_EXISTED(1023,"Seasonal rate existed"),
    SEASONAL_RATE_NOT_EXISTED(1024,"Seasonal rate not existed"),
    SCHEDULE_EXISTED(1025,"Schedule existed"),
    PRICE_EXISTED(1026,"Price existed"),
    PRICE_NOT_EXISTED(1027,"Price not existed"),
    INVALID_PRICE_RANGE(1028,"Invalid price range"),
    TICKET_EXISTED(1029,"Ticket existed"),
    STOP_SCHEDULE_NOT_EXISTED(1030,"Stop schedule not existed"),
    STOP_SCHEDULE_EXISTED(1031,"Stop schedule existed"),
    SCHEDULE_NOT_FOUND(1032,"Schedule not found"),
    STOP_SCHEDULE_NOT_FOUND(1033,"Stop schedule not found"),
    ;
    // Constructor
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private  int code = 1000;
    private  String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
