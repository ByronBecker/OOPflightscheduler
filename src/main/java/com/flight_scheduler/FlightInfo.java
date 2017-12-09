package com.flight_scheduler;

import javax.persistence.*;
import java.time.LocalDateTime;


@Embeddable
public class FlightInfo {

	private LocalDateTime early_time;
    private LocalDateTime late_time;
    private boolean critical_status;
    private String departure_location;
	private String arrival_location;
    private String airline;

    //Required for Hibernate
    public FlightInfo(){}

	public FlightInfo(LocalDateTime early_time,
                      LocalDateTime late_time,
                      boolean critical_status,
                      String departure_location,
                      String arrival_location,
                      String airline){

        this.early_time = early_time;
        this.late_time = late_time;
        this.critical_status = critical_status;
        this.departure_location = departure_location;
        this.arrival_location = arrival_location;
        this.airline = airline;
	}

    public LocalDateTime getEarly_time() {
        return early_time;
    }

    public LocalDateTime getLate_time() {
        return late_time;
    }

    public boolean isCritical_status() {
        return critical_status;
    }

    public String getDeparture_location() {
        return departure_location;
    }

    public String getArrival_location() {
        return arrival_location;
    }

    public String getAirline() {
        return airline;
    }
}
