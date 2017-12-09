package com.flight_scheduler;

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
}
