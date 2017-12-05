package com.kruse.hibernate;
//Note: This is showing the various abilities you can use hibernate for, in order to write, read, modify and delete form the database.


import java.io.*;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		SessionFactory session_factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		
		String file_name = "required_resources/DummyFlights.txt";
		writeToDatabaseinBatch(file_name, session_factory);
		
		
		writeToDatabase(session_factory);
		ArrayList<Flight> flights = readFromDatabase(session_factory);
		
		printFlights(flights);
		
		session_factory.close();
	}

	/*
	 * Regarding SupressWarnings: Hibernate does not allow the ability to type cast strictly with createQuery. 
	 * 								- Compiler will throw a warning without.
	 */
	public static ArrayList<Flight> readFromDatabase(SessionFactory session_factory) {
		System.out.println("READING FROM DATABSE\n...");
		Session session = session_factory.openSession();
		session.beginTransaction();
		
		@SuppressWarnings({ "unchecked" })
		ArrayList<Flight> flights = (ArrayList<Flight>) session.createQuery("from Flight").list();
		
		session.getTransaction().commit();
		session.close();
		
		return flights;
	}
	
	public static void writeToDatabase(SessionFactory session_factory) {
		System.out.println("WRITING TO DATABSE\n...");
		Flight flight = new Flight(20, "Kruse Airways", "Brisbane", "San Fran", LocalDateTime.now(), 5);
		
		Session session = session_factory.openSession();
		session.beginTransaction();
		
		session.save(flight);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void printFlights(ArrayList<Flight> flights) {
		System.out.println("Printing out current flight directory\n...");
		for (Flight flight: flights) {
			System.out.println("Flight Number     : " + flight.getFlight_number());
			System.out.println("Airline Namer     : " + flight.getAirline_name());
			System.out.println("Gate              : " + flight.getGate());
			System.out.println("Arrival Time      : " + flight.getArrival_time());	
			System.out.println("Arrival Location  : " + flight.getArrival_location());
			System.out.println("Departure Location: " + flight.getDeparture_location() + "\n");		
		}
	}
	
	public static void writeToDatabaseinBatch(String file_name, SessionFactory sessionFactory) {
		System.out.println("WRITING TO DATABSE FROM FILE\n...");
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
	
	

	
	
	
}
