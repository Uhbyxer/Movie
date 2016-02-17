package com.epam.spring.movie.aspect;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.spring.movie.AbstractTestCase;
import com.epam.spring.movie.bean.EventCounter;
import com.epam.spring.movie.service.EventCounterService;
import com.epam.spring.movie.service.EventService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CounterAspectTest extends AbstractTestCase {
	public static int testCounter = 0;
	
	@Autowired
	private EventCounterService eventCounterService;

	@Autowired
	private EventService eventService;
	
	public void setEventCounterService(EventCounterService eventCounterService) {
		this.eventCounterService = eventCounterService;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("\n*********************************************** CounterAspect Tests --->");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("\nTest # " + ++testCounter);
	}

	@Ignore
	@Test
	public void testGetByNameCounter() {
		EventCounter eventCounter = eventCounterService.getAll().get(0);
		System.out.println("Testing by name counter for event: " + eventCounter.getEvent().getName());
		
		
		System.out.println(eventCounter.getByNameCount());
		assertEquals(1, eventCounter.getByNameCount());
	}

	@Ignore
	@Test
	public void testGetPriceCounter() {
		EventCounter eventCounter = eventCounterService.getAll().get(1);
		System.out.println("Testing price counter for event: " + eventCounter.getEvent().getName());
		
		System.out.println(eventCounter.getPriceCount());
		assertEquals(4, eventCounter.getPriceCount());
	}

	@Ignore
	@Test
	public void testBookCounter() {
		EventCounter eventCounter = eventCounterService.getAll().get(1);
		System.out.println("Testing book counter for event: " + eventCounter.getEvent().getName());
		
		System.out.println(eventCounter.getBookCount());
		assertEquals(1, eventCounter.getBookCount());
	}

}
