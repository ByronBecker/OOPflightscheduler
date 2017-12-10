package com.flight_scheduler;

import static junit.framework.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.time.Month;

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
			HibernateTutorial.writeFlightToDatabase(flight_to_Write);

		assertTrue(HibernateTutorial.readFlightFromDatabase(flight_number).equals(flight_to_Write));
		
		session_factory.close();
		
	}
}
