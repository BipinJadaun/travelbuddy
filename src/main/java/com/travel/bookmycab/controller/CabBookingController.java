package com.travel.bookmycab.controller;

import com.travel.bookmycab.model.Trip;
import com.travel.bookmycab.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cab")
public class CabBookingController {
	
	@Autowired
	private BookingService service;

	@PostMapping("/addTrip")
	@PreAuthorize("hasRole('ROLE_USER')") //@PreAuthorize supports Spring expression language(SpEL) for more complex authorizations.
	//@Secured("ROLE_USER")  //@Secured is for simple authorizations
	public void startTrip(@RequestParam("userId") String userId, @RequestBody Trip trip){
		service.startTrip(userId, trip);
	}

	@PutMapping("/endTrip")
	@PreAuthorize("hasRole('ROLE_USER')")
	public void endCurrentTrip(@RequestParam("userId") String userId) {
		service.completeCurrentTrip(userId);
	}

	@DeleteMapping("/cancelTrip")
	@PreAuthorize("hasRole('ROLE_USER')")
	public void cancelCurrentTrip(@RequestParam("userId") String userId) {
		service.cancelCurrentTrip(userId);
	}

	@PutMapping("/updateTrip")
	@PreAuthorize("hasRole('ROLE_USER')")
	public void updateCurrentTrip(@RequestParam("userId") String userId, @RequestBody Trip trip) {
		service.updateCurrentTrip(userId, trip);
	}

	@GetMapping("/getCurrentTrip")
	@PreAuthorize("hasRole('ROLE_USER')")
	public Trip getCurrentTrip(@RequestParam("userId") String userId) {
		return service.getCurrentTrip(userId);
	}

	@GetMapping("/getBookingHistory")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Trip> getBookingHistory(@RequestParam("userId") String userId) {
		return service.getBookingHistory(userId);
	}
}
