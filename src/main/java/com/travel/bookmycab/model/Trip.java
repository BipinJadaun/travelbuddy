package com.travel.bookmycab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Document(collation = "trips")
public class Trip {

	@Id
	long tripId;
	String userId;
	LocalDateTime startTime;
	LocalDateTime endTime;
	Location pickupLocation;
	Location dropLocation;
	double fare;
	double distance;
	Offer offer;
	TripStatus tripStatus;

	public Trip(String userId, LocalDateTime startTime, Location pickupLocation, Location dropLocation) {
		this.userId = userId;
		this.startTime = startTime;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
	}
}
