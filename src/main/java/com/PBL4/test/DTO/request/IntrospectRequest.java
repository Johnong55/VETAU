package com.PBL4.test.DTO.request;

public class IntrospectRequest {

    String token;

    public IntrospectRequest() {}
    public IntrospectRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
