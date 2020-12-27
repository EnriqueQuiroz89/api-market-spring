package com.mexicode.market.domain.dto;

public class AuthenticationResponse {

    private String jwt;

    /**Constructor*/
    public AuthenticationResponse(String jwt){
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
