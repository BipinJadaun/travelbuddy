package com.travel.bookmycab.presenter;

import java.util.List;

import com.travel.bookmycab.model.Trip;
import org.springframework.stereotype.Service;


@Service
public class ReportPresenter {
	
	public void presentCompletedTrips(List<Trip> list) {
	
			System.out.println("Summary Report: ");
			System.out.println("...............................................................................................................");
			System.out.println("Trip Date" +"\t\t"+ "Pickup " +"\t\t"+ "Destination" +"\t\t"+  "Distance" +"\t"+  "FareType" +"\t\t"+  "Fare");
			System.out.println("...............................................................................................................");
			for (Trip trip : list) {
				System.out.println(trip.getEndTime()+"\t" +trip.getPickupLocation()+"\t" + trip.getDropLocation()+"\t\t"
				+ trip.getDistance()+"\t\t" + trip.getOffer()+"\t\t"  +trip.getFare());
			}			
		}
}
