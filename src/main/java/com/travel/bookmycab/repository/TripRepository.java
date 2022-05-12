package com.travel.bookmycab.repository;

import com.travel.bookmycab.model.Trip;
import com.travel.bookmycab.model.TripStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip, Double> {
    @Query("{userId : ?0, tripStatus : ?1}")
    List<Trip> findCompletedTrips(String userId, TripStatus status);

    @Query("{userId : ?0, tripStatus : ?1}")
    Trip findCurrentTrip(String userId, TripStatus status);
}
