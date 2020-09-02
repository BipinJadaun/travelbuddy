package com.geniusbrain.bookmycab.repository;

import com.geniusbrain.bookmycab.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Double> {


    @Query("select t from Trip t where t.userId=:userId and t.tripCompleted=false")
    Trip findCurrentTripByUserId(@Param("userId") String userId);

    @Query("select t from Trip t where t.userId=:userId and t.tripCompleted=true")
    List<Trip> findCompletedTripsByUserId(@Param("userId") String userId);
}
