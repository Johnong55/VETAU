package com.PBL4.test.DTO.request;

public class Authentication_Request {
    private String username;
    private String password;
    public String getUsername() {
        return username;

    }
    public String getPassword() {
        return password;
    }

    public Authentication_Request(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
