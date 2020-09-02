package com.geniusbrain.bookmycab.service;

import com.geniusbrain.bookmycab.model.Trip;

import java.util.List;

public interface BookingService {

    void startTrip(String userId, Trip trip);

    void completeCurrentTrip(String userId);

    void cancelCurrentTrip(String userId);

    Trip getCurrentTrip(String userId);

    List<Trip> getBookingHistory(String userId);

    void updateCurrentTrip(String userId, Trip trip);
}
