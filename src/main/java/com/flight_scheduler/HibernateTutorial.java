package com.flight_scheduler;
/* Note: This is showing the various abilities you can use hibernate for, in order to write, read, modify and delete form the database.
 * Further readings/tutorials:
 * 		- https://docs.jboss.org/hibernate/orm/3.6/quickstart/en-US/html/hibernate-gsg-tutorial-annotations.html 
 * 		- https://www.tutorialspoint.com/hibernate/hibernate_examples.htm and 
 * 		- https://docs.jboss.org/hibernate/orm/3.5/javadocs/org/hibernate/Session.html
 */

import java.io.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class HibernateTutorial {
	public static void testHibernateCommands() {
		SessionFactory session_factory = HibernateUtil.getSession_factory();
		Integer flight_number = 20;

		/* Needs to be updated for current flight class.
		//*WRITING* Many flights from a file to db
		String file_name = "main/resources/DummyFlights.txt";
		writeToDatabaseinBatch(file_name, session_factory);
		*/

		//*WRITING* A single flight to db
		Flight flight_to_Write = new Flight(flight_number,
                                            747,
                                            2,
											"A1",
                                            true,
                                            LocalDateTime.of(2017, Month.DECEMBER, 29, 4, 30, 0),
                                            LocalDateTime.of(2017, Month.DECEMBER, 29, 6, 40, 0),
                                            new FlightInfo( LocalDateTime.of(2017, Month.DECEMBER, 29, 0, 0, 0),
                                                            LocalDateTime.of(2017, Month.DECEMBER, 29, 8, 0, 0),
                                                            false,
                                                            "Denver, CO",
                                                            "Austin, TX",
                                                            "Southwest Airlines"));
		writeFlightToDatabase(flight_to_Write);
		
		//*READING* All flights stored in db
		ArrayList<Flight> flights = readAllFlightsFromDatabase();
		
		
		printFlights(flights);
		
		
		//*READING* A single flight stored in db from flight number
		Flight flight_read = readFlightFromDatabase(flight_number);
		
		//*MODIFY* The single flight in the db read from above if it was found in the db.
		if (flight_read != null) {
			flight_read.setGate("A2");
			updateFlightFromDatabase(flight_read);
		} else {
			System.out.println("Error: Flight with number: "+ flight_number + " not found");
		}
		
		
		printFlights(readAllFlightsFromDatabase());
		
		
		//*DELETE* A single flight number based on flight number:
		deleteFlightFromDatabase(readFlightFromDatabase(flight_number));
		
		
		printFlights(readAllFlightsFromDatabase());
		
		
		session_factory.close();
		
		
	}

	/*
	 * Regarding SupressWarnings: Hibernate does not allow the ability to type cast strictly with createQuery. 
	 * 								- Compiler will throw a warning without.
	 */
	public static ArrayList<Flight> readAllFlightsFromDatabase() {
		System.out.println("READING ALL FLIGHTS FROM DATABASE\n...");
		Session session = HibernateUtil.getSession_factory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings({ "unchecked" })
		ArrayList<Flight> flights = (ArrayList<Flight>) session.createQuery("from Flight").list();
		
		session.getTransaction().commit();
		session.close();
		
		return flights;
	}
	
	public static Flight readFlightFromDatabase(Integer flight_number) {
		System.out.println("READING A FLIGHT FROM DATABASE\nFlight Nubmer: " + flight_number +"\n...");
		Session session = HibernateUtil.getSession_factory().openSession();
		session.beginTransaction();
		
		Flight flight = session.get(Flight.class, flight_number);
		
		System.out.println("flight number of flight pulled is: " + flight.getFlight_number());
		
		session.getTransaction().commit();
		session.close();
		
		return flight;
	}
	
	public static void writeFlightToDatabase(Flight flight) {
		System.out.println("WRITING TO DATABASE\n...");
		if (flight == null) return;
		Session session = HibernateUtil.getSession_factory().openSession();
		session.beginTransaction();
		
		session.save(flight);
		
		session.getTransaction().commit();
		session.close();
	}
	
	//Credit to tutorial point hibernate link at top
	public static void updateFlightFromDatabase(Flight flight) {
		System.out.println("UPDATING DATABASE\n...");
		if (flight == null) return;
		Session session = HibernateUtil.getSession_factory().openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			session.update(flight);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			
			System.out.println("UPDATING ERROR");
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
	
	//Credit to tutorial point hibernate link at top
	public static void deleteFlightFromDatabase(Flight flight) {
		System.out.println("WRITING TO DATABASE\n...");
		if (flight == null) return;
		
		Session session = HibernateUtil.getSession_factory().openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			session.delete(flight);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			
			System.out.println("DELETING ERROR");
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}

	
	public static void printFlights(ArrayList<Flight> flights) {
		System.out.println("Printing out current flight directory\n...");
		for (Flight flight: flights) {
			System.out.println("Flight Number: 			" + flight.getFlight_number());
			System.out.println("Model Number: 			" + flight.getModel_number());
			System.out.println("Priority Status: 		" + flight.getPriority_status());
			System.out.println("Airline: 				" + flight.getFlight_Info().getAirline());
			System.out.println("Gate: 					" + flight.getGate());
			System.out.println("Departure Location: 	" + flight.getFlight_Info().getDeparture_location());
			System.out.println("Arrival Location: 		" + flight.getFlight_Info().getArrival_location());
			System.out.println("Is Departing: 			" + flight.isDeparting());
            System.out.println("Departure Time: 		" + flight.getArrival_time());
            System.out.println("Arrival Time:          	" + flight.getDeparture_time());
			System.out.println("Early Time: 			" + flight.getFlight_Info().getEarly_time());
			System.out.println("Late Time:            	" + flight.getFlight_Info().getLate_time());
			System.out.println("Critical Status Time: 	" + flight.getFlight_Info().isCritical_status() + "\n");
		}
	}

	/*
	public static void writeToDatabaseinBatch(String file_name, SessionFactory sessionFactory) {
		System.out.println("WRITING TO DATABASE FROM FILE\n...");
		String line = null;
        
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file_name));
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			while ((line = bufferedReader.readLine()) != null) {
				String delims = ",";
				String[] flight_details = line.split(delims);
				Flight flight_Iterator = new Flight();

				for (int i = 0; i < flight_details.length; i++) {
					if (i == 0) {
						flight_Iterator.setFlight_number(Integer.parseInt(flight_details[i]));
					} else if (i == 1) {
						flight_Iterator.setAirline_name(flight_details[i]);
					} else if (i == 2) {
						flight_Iterator.setArrival_location(flight_details[i]);
					} else if (i == 3) {
						flight_Iterator.setArrival_time(LocalDateTime.now());
					} else if (i == 4) {
						flight_Iterator.setDeparture_location(flight_details[i]);
					} else if (i == 5) {
						flight_Iterator.setGate(Integer.parseInt(flight_details[i]));
					} else {
						System.out.println("ERROR: Out of bounds");
					}
				}
				session.save(flight_Iterator);
			}
			
			session.getTransaction().commit();
			bufferedReader.close();
			session.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println("Error Opening File");
		} catch (IOException ex) {
			System.out.println("Error Reading File");
		}
	}
	*/
	
}
