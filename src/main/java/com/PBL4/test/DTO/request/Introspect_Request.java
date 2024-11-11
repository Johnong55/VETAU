package com.PBL4.test.DTO.request;

public class Introspect_Request {

    String token;

    public Introspect_Request() {}
    public Introspect_Request(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
