package com.travel.bookmycab.dao;

import java.util.List;

import com.travel.bookmycab.model.Trip;
import com.travel.bookmycab.model.TripStatus;
import com.travel.bookmycab.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BookingsDaoImpl implements BookingsDao {

	@Autowired
	private TripRepository tripRepository;


	@Override
	public void addCurrentTrip(Trip trip) {
		tripRepository.save(trip);
	}

	@Override
	public void updateCurrentTrip(Trip currentTrip) {
		tripRepository.save(currentTrip);
	}

	@Override
	public Trip getCurrentTrip(String userId) {
		return tripRepository.findCurrentTrip(userId, TripStatus.ON_GOING);
	}

	@Override
	public void cancelCurrentTrip(Trip currentTrip) {
		currentTrip.setTripStatus(TripStatus.CANCELLED);
		tripRepository.save(currentTrip);
	}

	@Override
	public void completeCurrentTrip(Trip currentTrip) {
		currentTrip.setTripStatus(TripStatus.COMPLETED);
		tripRepository.save(currentTrip);
	}

	@Override
	public List<Trip> getCompletedTrips(String userId) {
		return tripRepository.findCompletedTrips(userId, TripStatus.COMPLETED);
	}
}
