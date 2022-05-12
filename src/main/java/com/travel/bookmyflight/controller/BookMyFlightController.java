package com.travel.bookmyflight.controller;

import com.travel.bookmyflight.model.Flight;
import com.travel.bookmyflight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/flight")
public class BookMyFlightController {

    @Autowired
    private FlightService service;

    @PostMapping("/upload")
    public ResponseEntity<Boolean> uploadFlightSchedules(@RequestBody InputStream csvData) throws IOException {
        boolean result = service.uploadFlightSchedules(csvData, Flight.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
