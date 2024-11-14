package com.PBL4.test.DTO.response;

public class Introspect_Response {
    boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Introspect_Response(boolean valid) {
        this.valid = valid;
    }
}
