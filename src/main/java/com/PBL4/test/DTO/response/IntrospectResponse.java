package com.PBL4.test.DTO.response;

public class IntrospectResponse {
    boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public IntrospectResponse(boolean valid) {
        this.valid = valid;
    }
}
