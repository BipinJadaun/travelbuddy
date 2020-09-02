package com.geniusbrain.bookmycab.Dao;

import java.util.List;

import com.geniusbrain.bookmycab.model.Trip;
import com.geniusbrain.bookmycab.repository.TripRepository;
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
		return tripRepository.findCurrentTripByUserId(userId);
	}

	@Override
	public void cancelCurrentTrip(Trip currentTrip) {
		tripRepository.delete(currentTrip);
	}

	@Override
	public void completeCurrentTrip(Trip currentTrip) {
		currentTrip.setTripCompleted(true);
		tripRepository.save(currentTrip);
	}

	@Override
	public List<Trip> getCompletedTrips(String userId) {
		return tripRepository.findCompletedTripsByUserId(userId);
	}
}
