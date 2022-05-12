package com.travel;

import com.travel.appuser.model.AuthenticationRequest;
import com.travel.bookmycab.controller.CabBookingController;
import com.travel.appuser.controller.HomeController;
import com.travel.appuser.controller.UserController;
import com.travel.appuser.model.AppUser;
import com.travel.bookmycab.model.Location;
import com.travel.bookmycab.model.Trip;
import com.travel.exception.ResourceAlreadyExistException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
class TravelBuddyApplicationTests {

	@Autowired
	private CabBookingController bookingController;
	@Autowired
	private UserController userController;
	@Autowired
	private HomeController homeController;

	@Test
	public void testAddUser() {

		AppUser user = new AppUser("vinujadaun", "vinujadaun",
				"Vipin Jadaun","8892748648","vinujadaun.108@gmail.com",
				new Date());

		try {
			homeController.userRegistration(user);
		} catch (ResourceAlreadyExistException e) {
			assert e.getMessage().contains("User already exist");
		}
	}

	@Test
	public void testLogin(){
		AuthenticationRequest req = new AuthenticationRequest("vinujadaun", "1234567");
		ResponseEntity<?> response = homeController.login(req);
		System.out.println(response.getHeaders());
	}

	@Test
	public void getUser(){
		EntityModel<AppUser> vinujadaun = userController.getUser("vinujadaun");
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
