package com.thetestingacademy.modules.vwo;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.vwo.request.LoginRequest;
import com.thetestingacademy.pojos.vwo.response.LoginResponse;

public class VWOPayloadManger {
    Gson gson;

    // Java Object -> JSON
    public String setLoginData() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("contact+aug@thetestingacademy.com");
        loginRequest.setPassword("TtxkgQ!s$rJBk85");


        gson = new Gson();
        String jsonPayloadString = gson.toJson(loginRequest);
        System.out.println("Payload Login to the -> " + jsonPayloadString);
        return jsonPayloadString;

    }

    // DeSer ( JSON String -> Java Object
    public LoginResponse getLoginData(String loginResponseEx){
        gson = new Gson();
        LoginResponse loginResponse = gson.fromJson(loginResponseEx, LoginResponse.class);
        return  loginResponse;
    }
}
