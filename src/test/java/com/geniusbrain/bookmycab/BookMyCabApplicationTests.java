package com.geniusbrain.bookmycab;

import com.geniusbrain.bookmycab.controller.BookingController;
import com.geniusbrain.bookmycab.controller.HomeController;
import com.geniusbrain.bookmycab.controller.UserController;
import com.geniusbrain.bookmycab.exception.ResourceAlreadyExistException;
import com.geniusbrain.bookmycab.model.AppUser;
import com.geniusbrain.bookmycab.model.Location;
import com.geniusbrain.bookmycab.model.Trip;
import com.geniusbrain.bookmycab.model.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityModel;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
class BookMyCabApplicationTests {

	@Autowired
	private BookingController bookingController;
	@Autowired
	private UserController userController;
	@Autowired
	private HomeController homeController;

	@Test
	public void testAddUser() {
		UserDetails userDetails = new UserDetails("vinujadaun",
				"vipin jadaun", "8892748648",
				"vinujadaun@gmail.com",new Date(), 100);
		AppUser user = new AppUser("vinujadaun", "vinujadaun", "ROLE_USER");
		user.setUserDetails(userDetails);
		try {
			homeController.userRegistration(user);
		} catch (ResourceAlreadyExistException e) {
			assert e.getMessage().contains("UserDetails already exist");
		}
	}

	@Test
	public void getUser(){
		EntityModel<UserDetails> vinujadaun = userController.getUser("vinujadaun");
	}

	@Test
	public void testStartTrip() {
		String userId = "vinujadaun";
		Trip trip = new Trip(userId, getCurrentTime(), Location.LOCATION1 , Location.LOCATION7);
			bookingController.startTrip(userId, trip);
	}

	private LocalDateTime getCurrentTime() {
		return LocalDateTime.now();
	}

	@Test
	public void testEndTrip() {
		String userId = "vinujadaun";
		bookingController.endCurrentTrip(userId);
	}

	@Test
	public void testCompletedTrips() {
		String userId = "vinujadaun";
		testAddUser();
		testStartTrip();
		testEndTrip();
		bookingController.getBookingHistory(userId);
	}

}
