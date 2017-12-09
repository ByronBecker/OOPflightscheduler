package com.flight_scheduler;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name="FLIGHT_INFORMATION")
public class Flight {
	
	@Id
	private int flight_number;
	private int model_number;
	private int priority_status;
	private String airline;
	private String gate;
	private String departure_location;
	private String arrival_location;
	private boolean departing;
	private LocalDateTime early_time;
	private LocalDateTime late_time;
	private boolean critical_status;
	
	
	
	public Flight() {
		super();
	}

	public Flight(int flight_number, int model_number, int priority_status, String airline, String gate, String departure_location, String arrival_location,
				  Boolean departing, LocalDateTime early_time, LocalDateTime late_time, Boolean critical_status){
		super();

		this.flight_number = flight_number;
		this.model_number = model_number;
		this.priority_status = priority_status;
		this.airline = airline;;
		this.gate = gate;
		this.departure_location = departure_location;
		this.arrival_location = arrival_location;
		this.departing = departing;
		this.early_time = early_time;
		this.late_time = late_time;
		this.critical_status = critical_status;
	}

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}

	public int getModel_number() {
		return model_number;
	}

	public void setModel_number(int model_number) {
		this.model_number = model_number;
	}

	public int getPriority_status() {
		return priority_status;
	}

	public void setPriority_status(int priority_status) {
		this.priority_status = priority_status;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
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

	public boolean isIs_departure() {
		return departing;
	}

	public void setIs_departure(boolean departing) {
		this.departing = departing;
	}

	public LocalDateTime getEarly_time() {
		return early_time;
	}

	public void setEarly_time(LocalDateTime early_time) {
		this.early_time = early_time;
	}

	public LocalDateTime getLate_time() {
		return late_time;
	}

	public void setLate_time(LocalDateTime late_time) {
		this.late_time = late_time;
	}

	public boolean isCritical_status() {
		return critical_status;
	}

	public void setCritical_status(boolean critical_status) {
		this.critical_status = critical_status;
	}

	public void setTimeSlot(LocalDateTime early_time, LocalDateTime late_time){
		this.early_time = early_time;
		this.late_time = late_time;
	}
}
