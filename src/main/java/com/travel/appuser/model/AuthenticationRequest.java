package com.travel.appuser.model;

import lombok.Data;

@Data

public class AuthenticationRequest {

    private final String userId;
    private final String password;
}
