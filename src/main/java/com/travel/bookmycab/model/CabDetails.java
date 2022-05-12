package com.travel.bookmycab.model;

import lombok.Data;

@Data
public class CabDetails {

    private final CabType cabType;
    private final String cabNumber;
    private final String DriverId;
}
