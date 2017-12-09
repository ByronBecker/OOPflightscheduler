package com.flight_scheduler;


import java.time.LocalDateTime;

public class AirlinePersonnel {
    
    private int user_id;
    private String airline_name;
    private ArrayList<int> currentflights;

    public AirlinePersonnel(int user_id, String airline_name) {
        

    }

    public String getAirlineName() {
        return this.airline_name;
    }

    public Flight makeFlight(LocalDateTime early_time, LocalDateTime late_time, boolean critical_status, String departure_location, String arrival_location) {

    }

    public boolean confirm(FlightInfo requested_flight) {
        boolean confirmed = false;
        //confirmed = userInput(...)
        return confirmed;
    }

    public String getReason() {
        String user_input = "";
        //user_input = userInput(...)
        return user_input;
    }

}
