package com.travel.bookmycab.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import com.travel.bookmycab.model.Offer;
import com.travel.bookmycab.model.Location;
import org.springframework.stereotype.Service;


@Service
public class BookingServiceHelper {
	
	public Offer getFareType(LocalDateTime endTime) {
		if(endTime.getDayOfWeek() == DayOfWeek.SATURDAY || endTime.getDayOfWeek() == DayOfWeek.SUNDAY)
			return Offer.WEEKENDS;
		else
			return Offer.NO_OFFER;
	}

	public int getDistance(Location pickUpPoint, Location dropPoint) {
		return Math.abs(pickUpPoint.stationNumber() - dropPoint.stationNumber());
	}

	public double getFare(double distance, double fare, int surCharge) {
		return distance*fare + surCharge;
	}

}
