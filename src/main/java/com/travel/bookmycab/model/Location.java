package com.travel.bookmycab.model;

public enum Location {
	LOCATION1(1),
	LOCATION2(2),
	LOCATION3(3),
	LOCATION4(4),
	LOCATION5(5),
	LOCATION6(6),
	LOCATION7(7),
	LOCATION8(8),
	LOCATION9(9),
	LOCATION10(10);
	
	private final Integer location;
	
	Location(Integer location) {
		this.location = location;
	}
	
	public Integer stationNumber() {
		return location;
	}
}
