package com.flight_scheduler;

import java.time.LocalDateTime;
import java.time.Month;

import org.hibernate.SessionFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HibernateTutorialTest
		extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param hibernate_test name of the test case
	 */
	public HibernateTutorialTest( String hibernate_test )
	{
		super( hibernate_test );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( HibernateTutorialTest.class );
	}

	public void testApp()
	{
		assertTrue( true );
	}

	public void testSample()
	{
		//Do test here
		assertTrue( true );
	}
	
	public void testFlight() {
		
		SessionFactory session_factory = HibernateUtil.getSession_factory();
		int flight_number = 20;

		/* Needs to be updated for current flight class.
		//*WRITING* Many flights from a file to db
		String file_name = "main/resources/DummyFlights.txt";
		writeToDatabaseinBatch(file_name, session_factory);
		*/
		
		//*WRITING* A single flight to db
		Flight flight_to_Write = new Flight(flight_number,
											747,
											1,
											"Southwest Airlines",
											"A1",
											"Denver, CO",
											"Austin, TX",
											true,
											LocalDateTime.of(2017, Month.DECEMBER, 29, 4, 30, 0),
											LocalDateTime.of(2017, Month.DECEMBER, 29, 6, 40, 0),
											false);
		HibernateTutorial.writeFlightToDatabase(flight_to_Write);
		
		
		assertTrue(HibernateTutorial.readFlightFromDatabase(flight_number).getFlight_number() == flight_to_Write.getFlight_number());
		
		
		
		session_factory.close();
		
	}
	
}
