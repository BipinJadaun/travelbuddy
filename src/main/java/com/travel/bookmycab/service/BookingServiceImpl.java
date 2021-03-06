package com.travel.bookmycab.service;

import java.time.LocalDateTime;
import java.util.List;

import com.travel.appuser.model.AppUser;
import com.travel.bookmycab.dao.BookingsDao;
import com.travel.appuser.dao.UserDao;
import com.travel.bookmycab.model.Offer;
import com.travel.bookmycab.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingsDao bookingDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookingServiceHelper serviceHelper;


	@Override
	public void startTrip(String userId, Trip trip) {
		AppUser userDetails = userDao.getUser(userId);
		if (userDetails.getWalletMoney() < 5) {
			System.out.println("insufficient wallet balance for a trip, Please pay cash");
		}
		trip.setStartTime(LocalDateTime.now());
		bookingDao.addCurrentTrip(trip);
	}

	@Override
	public void completeCurrentTrip(String userId) {
		AppUser userDetails = userDao.getUser(userId);
		Trip currTrip = getCurrentTrip(userId);
		if (currTrip != null) {
			Offer fareType = serviceHelper.getFareType(currTrip.getStartTime());
			double distance = serviceHelper.getDistance(currTrip.getPickupLocation(), currTrip.getDropLocation());
			double fare = serviceHelper.getFare(distance, fareType.getFare(), 0);
			currTrip.setEndTime(LocalDateTime.now());
			currTrip.setDistance(distance);
			currTrip.setOffer(fareType);
			currTrip.setFare(fare);

			if(userDetails.getWalletMoney() < fare) {
				System.out.println("insufficient Wallet balance, Pls pay cash");
			}else {
				userDetails.setWalletMoney(userDetails.getWalletMoney() - fare);
			}
			bookingDao.completeCurrentTrip(currTrip);
		}
	}

	@Override
	public void cancelCurrentTrip(String userId) {
		Trip currentTrip = getCurrentTrip(userId);
		if (currentTrip != null) {
			bookingDao.cancelCurrentTrip(currentTrip);
		}
	}

	@Override
	public Trip getCurrentTrip(String userId) {
		final Trip currentTrip = bookingDao.getCurrentTrip(userId);
		if (currentTrip == null){
			System.out.println("No ongoing trip for user: "+ userId);
		}
		return currentTrip;
	}

	@Override
	public List<Trip> getBookingHistory(String userId) {
		return bookingDao.getCompletedTrips(userId);
	}

	@Override
	public void updateCurrentTrip(String userId, Trip trip) {
		Trip currTrip = getCurrentTrip(userId);
		if(currTrip != null) {
			currTrip.setDropLocation(trip.getDropLocation());
			bookingDao.updateCurrentTrip(currTrip);
		}
	}
}
