package com.travel.bookmyflight.service;

import com.travel.bookmyflight.model.Flight;
import com.travel.bookmyflight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public boolean uploadFlightSchedules(InputStream csvData, Class<Flight> flightClass) throws IOException {
        List<Flight> flights = FlightUtils.read(flightClass, csvData);
        repository.saveAll(flights);
        return true;
    }
}
