package com.travel.bookmyflight.repository;

import com.travel.bookmyflight.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends MongoRepository<Flight, Integer> {
}
