package com.kruse.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
/*If you want to store the object as a 
 * different table name e.g. 
 * STUDENT_INFORMATION vs default Student_Info
 */
@Table(name="FLIGHT_INFORMATION")
public class Flights {
	
	@Id
	private int flight_number;
	private String airline_name;
	private String departure_location;
	private String arrival_location;
	private int arrival_time;
	private int gate;
	
	public int getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	public String getAirline_name() {
		return airline_name;
	}
	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
	public String getDeparture_location() {
		return departure_location;
	}
	public void setDeparture_location(String departure_location) {
		this.departure_location = departure_location;
	}
	public String getArrival_location() {
		return arrival_location;
	}
	public void setArrival_location(String arrival_location) {
		this.arrival_location = arrival_location;
	}
	public int getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(int arrival_time) {
		this.arrival_time = arrival_time;
	}
	public int getGate() {
		return gate;
	}
	public void setGate(int gate) {
		this.gate = gate;
	}
}
