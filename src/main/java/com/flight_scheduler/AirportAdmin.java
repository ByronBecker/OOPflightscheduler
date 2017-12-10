package com.flight_scheduler;

public class AirportAdmin {
	private int user_id = 0;
	private int number_gates;
	
	public AirportAdmin() {

	}

	public boolean changeFlightStatus(Flight flight, boolean status) {
		return false;
	}

	public boolean assignFlightPriority(Flight flight, int priority) {

		return false;
	}

	public void assignAirlinePriority(String airline, int priority) {

	}

	public boolean approveFlightRequest(FlightInfo requested_flight, String explanation) {

		return false;
	}

	public boolean confirm() {

		return false;
	}

	public void setNumberOfGates(int number_gates) {
		this.number_gates = number_gates;
	}

	

}
