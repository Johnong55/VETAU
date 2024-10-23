package com.PBL4.test.Exception;

public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),

    ACCOUNT_EXISTED(1002, "Account already existed"),
    ACCOUNT_NOT_EXISTED(1003, "Account not existed"),
    INVALID_PASSWORD(1004, "Invalid password"),
    INVALID_KEY(1005, "Invalid key"),
    UNAUTHENTICATED(1006,"Unauthenticated"),
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
