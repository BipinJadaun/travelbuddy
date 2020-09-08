package com.geniusbrain.bookmycab;

import com.geniusbrain.bookmycab.controller.BookingController;
import com.geniusbrain.bookmycab.controller.UserController;
import com.geniusbrain.bookmycab.exception.ResourceAlreadyExistException;
import com.geniusbrain.bookmycab.exception.ResourceNotFoundException;
import com.geniusbrain.bookmycab.model.Location;
import com.geniusbrain.bookmycab.model.Trip;
import com.geniusbrain.bookmycab.model.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BookMyCabApplicationTests {

	@Autowired
	private BookingController bookingController;
	@Autowired
	private UserController userController;

	@Test
	public void testAddUser() {
		UserDetails userDetails = new UserDetails("vinujadaun", "vipin jadaun", "8892748648", "vinujadaun@gmail.com", 100);
		try {
			userController.userRegistration(userDetails);
		} catch (ResourceAlreadyExistException e) {
			assert e.getMessage().contains("UserDetails already exist");
		}
	}

	@Test
	public void getUser(){
		try{
			UserDetails userDetails = userController.getUser("vinujadaun");
		} catch (ResourceNotFoundException e) {
			assert e.getMessage().contains("Invalid user");
		}
	}

	@Test
	public void testStartTrip() {
		String userId = "vinujadaun";
		Trip trip = new Trip(userId, getCurrentTime(), Location.LOCATION1 , Location.LOCATION7);
		try {
			bookingController.startTrip(userId, trip);
		} catch (ResourceNotFoundException e) {
			assert e.getMessage().contains("Invalid user");
		}

	}

	private LocalDateTime getCurrentTime() {
		return LocalDateTime.now();
	}

	@Test
	public void testEndTrip() {
		String userId = "vinujadaun";
		try {
			bookingController.endCurrentTrip(userId);
		} catch (ResourceNotFoundException e) {
			assert e.getMessage().contains("Invalid user");
		}
	}

	@Test
	public void testCompletedTrips() {
		String userId = "vinujadaun";
		testAddUser();
		testStartTrip();
		testEndTrip();
		try {
			bookingController.getBookingHistory(userId);
		} catch (ResourceNotFoundException e) {
			assert e.getMessage().contains("Invalid user");
		}

	}

}
