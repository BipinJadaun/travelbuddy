package com.travel.bookmycab.service;

import com.travel.bookmycab.model.Trip;

import java.util.List;

public interface BookingService {

    void startTrip(String userId, Trip trip);

    void completeCurrentTrip(String userId);

    void cancelCurrentTrip(String userId);

    Trip getCurrentTrip(String userId);

    List<Trip> getBookingHistory(String userId);

    void updateCurrentTrip(String userId, Trip trip);
}
