package com.flight_scheduler;

import com.flight_scheduler.Flight;
import com.flight_scheduler.FlightInfo;
import com.flight_scheduler.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Model {
	 public boolean openGateExists(Flight flight) {
		 return false;
	 }
	 public Flight bumpFlight(FlightInfo requested_flight) {

	 	return new Flight();
	 }
	 //public cancelledInfo(Flight cancelled_flight): String, int // Figure out what to return
	 
	 public void notifyAirline(String airline, int flight_number) {
		 
	 }

	 public boolean cancelFlights(ArrayList<Flight> flights) {
		 Session session = HibernateUtil.getSession_factory().openSession();
		 Transaction transaction = null;

		 transaction = session.beginTransaction();

		 for (Flight flight : flights) {
			 if (flight == null) return false;

			 try {
				 session.delete(flight);
			 } catch (HibernateException e) {

				 System.out.println("DELETING ERROR");
				 if (transaction != null) transaction.rollback();
				 e.printStackTrace();

			 }

		 }
		 session.getTransaction().commit();
		 session.close();

		 return true;
	 }

	 public boolean cancelFlightsByNumber(int flight_number){
	     ArrayList<Flight> cancelled_flights = new ArrayList<Flight>();
	     cancelled_flights.add(getFlightbyNumber(flight_number));
	     return cancelFlights(cancelled_flights);
     }

    public boolean cancelFlightsByTimeWindow(LocalDateTime early_time, LocalDateTime late_time, String airline){
        Session session = HibernateUtil.getSession_factory().openSession();
        session.beginTransaction();

        DateTimeFormatter sql_date_time_formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm00");
        String early_time_as_string = early_time.format(sql_date_time_formatter);
        String late_time_as_string = late_time.format(sql_date_time_formatter);

        @SuppressWarnings({ "unchecked" })
        ArrayList<Flight> flights = (ArrayList<Flight>) session.createQuery("from Flight WHERE (arrival_time >= " + early_time_as_string + " AND arrival_time <= " + late_time_as_string + " AND departing = 0) OR (departure_time >= "+ early_time_as_string +" AND departure_time <= " + late_time_as_string + " AND departing = 1) AND airline = '" + airline+ "'").list();

        session.getTransaction().commit();
        session.close();

        return cancelFlights(flights);
    }

    public boolean cancelFlightsByTimeWindow(LocalDateTime early_time, LocalDateTime late_time){
        Session session = HibernateUtil.getSession_factory().openSession();
        session.beginTransaction();

        DateTimeFormatter sql_date_time_formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm00");
        String early_time_as_string = early_time.format(sql_date_time_formatter);
        String late_time_as_string = late_time.format(sql_date_time_formatter);

        @SuppressWarnings({ "unchecked" })
        ArrayList<Flight> flights = (ArrayList<Flight>) session.createQuery("from Flight WHERE (arrival_time >= " + early_time_as_string + " AND arrival_time <= " + late_time_as_string + " AND departing = 0) OR (departure_time >= "+ early_time_as_string +" AND departure_time <= " + late_time_as_string + " AND departing = 1)").list();

        session.getTransaction().commit();
        session.close();

        return cancelFlights(flights);
    }


    public Flight getFlightbyNumber(int flight_number) {
		 Session session = HibernateUtil.getSession_factory().openSession();
		 session.beginTransaction();

		 Flight flight = session.get(Flight.class, flight_number);

		 session.getTransaction().commit();
		 session.close();

		 return flight;
	 }

	 public ArrayList<Flight> getFlightsbyTimeWindow(LocalDateTime early_time, LocalDateTime late_time) {
         Session session = HibernateUtil.getSession_factory().openSession();
         session.beginTransaction();

         DateTimeFormatter sql_date_time_formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm00");
         String early_time_as_string = early_time.format(sql_date_time_formatter);
         String late_time_as_string = late_time.format(sql_date_time_formatter);

         @SuppressWarnings({ "unchecked" })
         ArrayList<Flight> flights = (ArrayList<Flight>) session.createQuery("from Flight WHERE (arrival_time >= " + early_time_as_string + " AND arrival_time <= " + late_time_as_string + " AND departing = 0) OR (departure_time >= "+ early_time_as_string +" AND departure_time <= " + late_time_as_string + " AND departing = 1)").list();

         session.getTransaction().commit();
         session.close();

         return flights;
	 }

	 public ArrayList<Flight> getFlightsByAirline(String airline){
		 Session session = HibernateUtil.getSession_factory().openSession();
		 session.beginTransaction();

		 @SuppressWarnings({ "unchecked" })
		 ArrayList<Flight> flights = (ArrayList<Flight>) session.createQuery("from Flight where airline like '"+ airline +"'").list();

		 session.getTransaction().commit();
		 session.close();

		 return flights;
	 }

	public void updateNolifications(String airline, int flightNumber, boolean approved) {
		 
	 }

	 public void changeNumberofGates(int number) {
		 
	 }

	 public void addFlight(Flight flight) {
		 Session session = HibernateUtil.getSession_factory().openSession();
		 session.beginTransaction();

		 session.save(flight);

		 session.getTransaction().commit();
		 session.close();
	 }
}
