//package com.flight_scheduler;
//
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//import org.hibernate.SessionFactory;
//
//import java.lang.reflect.Array;
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//
///**
// * Unit test for simple App.
// */
//public class ModelTest
//		extends TestCase
//{
//
//	private Model model = new Model();
//
//	private String first_airline = "Southwest Airlines";
//
//	private LocalDateTime early_time = LocalDateTime.of(2017, Month.DECEMBER, 29, 0, 0, 0);
//	private LocalDateTime late_time = LocalDateTime.of(2017, Month.DECEMBER, 29, 8, 0, 0);
//
//	private int first_flight_number = -1;
//
//	private Flight first_flight = new Flight(first_flight_number,
//			747,
//			2,
//			"A1",
//			true,
//			LocalDateTime.of(2017, Month.DECEMBER, 29, 4, 30, 0),
//			LocalDateTime.of(2017, Month.DECEMBER, 29, 6, 40, 0),
//			new FlightInfo( early_time,
//					late_time,
//					false,
//					"Denver, CO",
//					"Austin, TX",
//					first_airline));
//
//	private Flight second_flight = new Flight(-2,
//			8380,
//			1,
//			"A3",
//			true,
//			LocalDateTime.of(2017, Month.JANUARY, 29, 4, 30, 0),
//			LocalDateTime.of(2017, Month.JANUARY, 29, 6, 40, 0),
//			new FlightInfo( LocalDateTime.of(2017, Month.JANUARY, 29, 0, 0, 0),
//					LocalDateTime.of(2017, Month.JANUARY, 29, 8, 0, 0),
//					false,
//					"Denver, CO",
//					"Los Angeles, CA",
//					"United Airlines"));
//
//    private Flight third_flight = new Flight(-3,
//            8380,
//            1,
//            "A4",
//            false,
//            LocalDateTime.of(2017, Month.DECEMBER, 29, 4, 30, 0),
//            LocalDateTime.of(2017, Month.DECEMBER, 29, 6, 40, 0),
//            new FlightInfo( LocalDateTime.of(2017, Month.DECEMBER, 29, 0, 0, 0),
//                    LocalDateTime.of(2017, Month.DECEMBER, 29, 8, 0, 0),
//                    false,
//                    "Denver, CO",
//                    "Portland, OR",
//                    "United Airlines"));
//
//	/**
//	 * Create the test case
//	 *
//	 * @param hibernate_test name of the test case
//	 */
//	public AirportSubjectTest(String hibernate_test )
//	{
//		super( hibernate_test );
//	}
//
//	/**
//	 * @return the suite of tests being tested
//	 */
//	public static Test suite()
//	{
//		return new TestSuite( ModelTest.class );
//	}
//	
//	public void testNotifyingAirportPersonnel() {
//		AirportPersonnel personnel = new AirportPersonnel(1,"United Airlines");
//		
//		
//	}
//
//}
