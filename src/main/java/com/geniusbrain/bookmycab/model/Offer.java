package com.geniusbrain.bookmycab.model;

public enum Offer {
	WEEKDAYS("No Offer", 8.0),
	WEEKENDS("Weekend offer", 6.0),
	FESTIVALS("Festival offer", 5.0);
	
	private final String offerType;
	private final double fare;
	
	Offer(String offerType, double fare){
		this.offerType = offerType;
		this.fare = fare;
	}
	
	public String getOfferType() {
		return offerType;
	}
	
	public double getFare() {
		return fare;
	}
}
