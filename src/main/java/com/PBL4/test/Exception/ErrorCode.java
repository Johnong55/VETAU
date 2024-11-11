package com.PBL4.test.Exception;

public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    ACCOUNT_EXISTED(1002, "Account already existed"),
    ACCOUNT_NOT_EXISTED(1003, "Account not existed"),
    INVALID_PASSWORD(1004, "Invalid password"),
    INVALID_KEY(1005, "Invalid key"),
    UNAUTHENTICATED(1006,"Unauthenticated"),
    SCHEDULE_NOTEXISTED(1007,"Schedule not existed"),
    TrainTrip_NOTEXISTED(1008,"Train not existed"),
    CITY_EXISTED(1009,"City existed"),
    CITY_NOT_EXISTED(1010,"City not existed"),
    STATION_EXISTED(1011,"Station existed"),
    STATION_NOT_EXISTED(1012,"Station not existed"),
    TRAIN_EXISTED(1013,"Train existed"),
    TRAIN_NOT_EXISTED(1014,"Train not existed"),
    EMAIL_EXISTED(1015,"Email existed"),
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
