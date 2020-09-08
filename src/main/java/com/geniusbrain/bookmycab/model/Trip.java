package com.geniusbrain.bookmycab.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trips")
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trip_id")
	long tripId;

	@NotBlank
	@Column(name = "user_id")
	String userId;

	@Column(name = "start_time")
	LocalDateTime startTime;

	@Column(name = "end_time")
	LocalDateTime endTime;

	@NotNull
	@Column(name = "pickup_location")
	Location pickupLocation;

	@NotNull
	@Column(name = "drop_location")
	Location dropLocation;

	@Column(name = "fare")
	double fare;

	@Column(name = "distance")
	double distance;

	@Column(name = "offer")
	Offer offer;

	@Column(name = "trip_completed")
	boolean tripCompleted;

	public Trip() {
	}

	public Trip(String userId, LocalDateTime startTime, Location pickupLocation, Location dropLocation) {
		this.userId = userId;
		this.startTime = startTime;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.tripCompleted = false;
	}

	public long getTripId() {
		return tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Location getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(Location pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public Location getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(Location dropLocation) {
		this.dropLocation = dropLocation;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public boolean getTripCompleted() {
		return tripCompleted;
	}
	public void setTripCompleted(boolean tripCompleted) {
		this.tripCompleted = tripCompleted;
	}

	@Override
	public String toString() {
		return "Trip{" +
				"tripId=" + tripId +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", startLocation=" + pickupLocation +
				", endLocation=" + dropLocation +
				", fare=" + fare +
				", distance=" + distance +
				", offer=" + offer +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Trip trip = (Trip) o;
		return Long.compare(trip.tripId, tripId) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tripId);
	}
}
