package com.geniusbrain.bookmycab.service;

import java.time.LocalDateTime;
import java.util.List;

import com.geniusbrain.bookmycab.Dao.BookingsDao;
import com.geniusbrain.bookmycab.Dao.UserDao;
import com.geniusbrain.bookmycab.model.Offer;
import com.geniusbrain.bookmycab.model.Trip;
import com.geniusbrain.bookmycab.model.User;
import com.geniusbrain.bookmycab.presenter.ReportPresenter;
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
		User user = userDao.getUser(userId);
		if (user.getWalletMoney() < 5) {
			System.out.println("insufficient wallet balance for a trip, Please pay cash");
		}
		trip.setStartTime(LocalDateTime.now());
		bookingDao.addCurrentTrip(trip);
	}

	@Override
	public void completeCurrentTrip(String userId) {
		User user = userDao.getUser(userId);
		Trip currTrip = getCurrentTrip(userId);
		if (currTrip != null) {
			Offer fareType = serviceHelper.getFareType(currTrip.getStartTime());
			double distance = serviceHelper.getDistance(currTrip.getPickupLocation(), currTrip.getDropLocation());
			double fare = serviceHelper.getFare(distance, fareType.getFare(), 0);
			currTrip.setEndTime(LocalDateTime.now());
			currTrip.setDistance(distance);
			currTrip.setOffer(fareType);
			currTrip.setFare(fare);

			if(user.getWalletMoney() < fare) {
				System.out.println("insufficient Wallet balance, Pls pay cash");
			}else {
				user.setWalletMoney(user.getWalletMoney() - fare);
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
