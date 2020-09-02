package com.geniusbrain.bookmycab.controller;

import com.geniusbrain.bookmycab.exception.ResourceNotFoundException;
import com.geniusbrain.bookmycab.model.Trip;
import com.geniusbrain.bookmycab.service.BookingService;
import com.geniusbrain.bookmycab.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService service;
	@Autowired
	private ValidationService validationService;

	@PostMapping("/startTrip")
	public void startTrip(@RequestParam("userId") String userId, @RequestBody Trip trip) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		service.startTrip(userId, trip);
	}

	@PutMapping("/endTrip")
	public void endCurrentTrip(@RequestParam("userId") String userId) throws ResourceNotFoundException  {
		validationService.validateUser(userId);
		service.completeCurrentTrip(userId);
	}

	@DeleteMapping("/cancelTrip")
	public void cancelCurrentTrip(@RequestParam("userId") String userId) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		service.cancelCurrentTrip(userId);
	}

	@PutMapping("/updateTrip")
	public void updateCurrentTrip(@RequestParam("userId") String userId, @RequestBody Trip trip) throws ResourceNotFoundException  {
		validationService.validateUser(userId);
		service.updateCurrentTrip(userId, trip);
	}

	@GetMapping("/getCurrentTrip")
	public Trip getCurrentTrip(@RequestParam("userId") String userId) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		return service.getCurrentTrip(userId);
	}

	@GetMapping("/getBookingHistory")
	public List<Trip> getBookingHistory(@RequestParam("userId") String userId) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		return service.getBookingHistory(userId);
	}
}
