package com.flight_scheduler;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="FLIGHT_INFORMATION")
public class Flight{
	
	@Id
	private int flight_number;
	private int model_number;
	private int priority_status;
	private String gate;
	private boolean departing;
    private LocalDateTime departure_time;
    private LocalDateTime arrival_time;

    @Embedded
	private FlightInfo flight_info;
	
	
	
	public Flight() {	}

	public Flight(int flight_number,
                  int model_number,
                  int priority_status,
                  String gate,
                  Boolean departing,
                  LocalDateTime departure_time,
                  LocalDateTime arrival_time,
                  FlightInfo flight_info){
		this.flight_number = flight_number;
		this.model_number = model_number;
		this.priority_status = priority_status;
		this.gate = gate;
		this.departing = departing;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.flight_info = flight_info;
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

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public boolean isDeparting() {
		return departing;
	}

	public void setDeparting(boolean departing) {
		this.departing = departing;
	}

    public void setFlightTimes(LocalDateTime departure_time, LocalDateTime arrival_time){
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
	}

    public LocalDateTime[] getTimeSlot(){
        LocalDateTime time_slot[] = {flight_info.getEarly_time(), flight_info.getLate_time()};
        return time_slot;
    }

    public FlightInfo getFlight_Info() {
        return flight_info;
    }

    public void setFlight_Info(FlightInfo flight_Info) {
        this.flight_info = flight_Info;
    }

    public LocalDateTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalDateTime departure_time) {
        this.departure_time = departure_time;
    }

    public LocalDateTime getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(LocalDateTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    @Override
	public boolean equals(Object object){

    	if (object == this) {
			return true;
		}

    	if (!(object instanceof Flight)){
    		return false;
		}

		Flight flight = (Flight) object;

		boolean equality = 	Integer.compare(this.flight_number,flight.getFlight_number()) == 0 &&
							Integer.compare(this.model_number,flight.getModel_number()) == 0 &&
							Integer.compare(this.priority_status, flight.getPriority_status()) == 0 &&
							this.gate.equals(flight.getGate()) &&
							this.departing == flight.isDeparting() &&
							this.departure_time.isEqual(flight.getDeparture_time()) &&
							this.arrival_time.isEqual(flight.getArrival_time()) &&
							this.flight_info.equals(flight.getFlight_Info());

    	return equality;
	}
}
