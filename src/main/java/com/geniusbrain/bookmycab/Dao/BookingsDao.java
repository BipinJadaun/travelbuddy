package com.geniusbrain.bookmycab.Dao;

import com.geniusbrain.bookmycab.model.Trip;

import java.util.List;

public interface BookingsDao {
    void addCurrentTrip(Trip trip);

    void updateCurrentTrip(Trip trip);

    Trip getCurrentTrip(String userId);

    void cancelCurrentTrip(Trip currentTrip);

    void completeCurrentTrip(Trip currTrip);

    List<Trip> getCompletedTrips(String userId);
}
