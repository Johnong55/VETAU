package com.PBL4.test.Exception;

import com.PBL4.test.enums.ErrorCode;

public class AppException extends RuntimeException {
    private ErrorCode errorcode;

    public AppException(ErrorCode errorcode) {
        this.errorcode = errorcode;
    }

    public ErrorCode getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(ErrorCode errorcode) {
        this.errorcode = errorcode;
    }
}
