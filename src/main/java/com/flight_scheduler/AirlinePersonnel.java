package com.flight_scheduler;


import java.time.LocalDateTime;
import java.util.ArrayList;

//@Entity
//@Table(name="AIRLINEPERSONNEL_INFORMATION")
public class AirlinePersonnel{ //implements Observer{
    
    private int user_id;
    private String airline_name;
    private String message;
    //private ArrayList<int> currentflights;

    public AirlinePersonnel(int user_id, String airline_name) {
    		this.user_id = user_id;
    		this.airline_name = airline_name;
    }

    public String getAirlineName() {
        return this.airline_name;
    }

    public void /*Flight*/ makeFlight(LocalDateTime early_time, LocalDateTime late_time, boolean critical_status, String departure_location, String arrival_location) {

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
    
    public void updateNotification(int flightNumber, boolean approved) {
    		if(approved)
    			message = "FlightNumber " + flightNumber +" approved";
    		else 
    			message = "FlightNumber " + flightNumber +" rejected";
    		
		/*Session session = HibernateUtil.getSession_factory().openSession();
		session.beginTransaction();
		
		session.save(this);
		
		session.getTransaction().commit();
		session.close();
		*/
    }
    
    /*
    public ArrayList<String> checkRecentUpdates(){
		Session session = HibernateUtil.getSession_factory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings({ "unchecked" })
		ArrayList<AirlinePersonnel> personnel = (ArrayList<AirlinePersonnel>) session.createQuery("from AirlinePersonnel WHERE user_id = "+ user_id).list();
		
		session.getTransaction().commit();
		session.close();
		
		ArrayList<String> airline_personnel_messages = new ArrayList<String>();
		
		for (AirlinePersonnel p: airline_personnel_messages) {
			airline_personnel_messages.add(p.getMessage());
		}
		
		return airline_personnel_messages;
    }
    */
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

}
