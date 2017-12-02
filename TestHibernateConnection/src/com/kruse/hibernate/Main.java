package com.kruse.hibernate;

import java.io.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {
		// Student_Info student = new Student_Info();
		//
		// student.setName("Johnathan");
		// student.setRollNo(1);
		//
		// Configuration config = new Configuration();
		// SessionFactory sessionFactory =
		// config.configure("hibernate.cfg.xml").buildSessionFactory();
		//
		// Session session = sessionFactory.openSession();
		// session.beginTransaction();
		// session.save(student);
		//
		// session.getTransaction().commit();
		// session.close();
		// sessionFactory.close();

		Flights flight = new Flights();

		flight.setFlight_number(1);
		flight.setAirline_name("Southwest");
		flight.setDeparture_location("Denver");
		flight.setArrival_location("Sand Fran");
		flight.setArrival_time(4);
		flight.setGate(1);

		String fileName = "required_resources/DummyFlights.txt";
		String line = null;

		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(flight);

		session.getTransaction().commit();
		// session.close();

		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			session.beginTransaction();
			while ((line = bufferedReader.readLine()) != null) {
				String delims = ",";
				String[] flight_details = line.split(delims);
				Flights flight_Iterator = new Flights();

				for (int i = 0; i < flight_details.length; i++) {
					if (i == 0) {
						flight_Iterator.setFlight_number(Integer.parseInt(flight_details[i]));
					} else if (i == 1) {
						flight_Iterator.setAirline_name(flight_details[i]);
					} else if (i == 2) {
						flight_Iterator.setArrival_location(flight_details[i]);
					} else if (i == 3) {
						flight_Iterator.setArrival_time(Integer.parseInt(flight_details[i]));
					} else if (i == 4) {
						flight_Iterator.setDeparture_location(flight_details[i]);
					} else if (i == 5) {
						flight_Iterator.setGate(Integer.parseInt(flight_details[i]));
					} else {
						System.out.println("ERROR: Out of bounds");
					}
				}

				// session = sessionFactory.openSession();

				session.save(flight_Iterator);

			}
			session.getTransaction().commit();
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Error Opening File");
		} catch (IOException ex) {
			System.out.println("Error Reading File");
		}
		session.close();
		sessionFactory.close();

	}

}
