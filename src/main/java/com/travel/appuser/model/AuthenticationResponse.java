package com.travel.appuser.model;

import lombok.Data;

@Data
public class AuthenticationResponse {

    private final String jwtToken;
}
