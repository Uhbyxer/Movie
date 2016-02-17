package com.epam.spring.movie.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.spring.movie.AbstractTestCase;
import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.EventCounter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EventCounterServiceTest extends AbstractTestCase {
	
	public static int testCounter = 0;
	
	@Autowired
	private EventCounterService eventCounterService;
	
	@Autowired
	private EventService eventService;
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setEventCounterService(EventCounterService eventCounterService) {
		this.eventCounterService = eventCounterService;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("\n*********************************************** EventServiceCounter Tests --->");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("\nTest # " + ++testCounter);
	}
	

	@Test
	public void testIncrementAndGetByNameCount() {
		System.out.println("Counting by name: ");
		Event event = eventService.getAll().get(0);
		int count = eventCounterService.incrementAndGetByNameCount(event);
		System.out.println(count);
		System.out.println(eventCounterService.incrementAndGetByNameCount(event));
		System.out.println(eventCounterService.incrementAndGetByNameCount(event));
		assertEquals(count + 3, eventCounterService.incrementAndGetByNameCount(event));
	}

	@Test
	public void testIncrementAndGetPriceCount() {
		System.out.println("Counting by price: ");
		Event event = eventService.getAll().get(0);
		int count = eventCounterService.incrementAndGetPriceCount(event);
		System.out.println(count);
		System.out.println(eventCounterService.incrementAndGetPriceCount(event));
		System.out.println(eventCounterService.incrementAndGetPriceCount(event));
		assertEquals(count + 3, eventCounterService.incrementAndGetPriceCount(event));
	}

	@Test
	public void testIncrementAndGetBookCount() {
		System.out.println("Counting by price: ");
		Event event = eventService.getAll().get(0);
		int count = eventCounterService.incrementAndGetBookCount(event);
		System.out.println(count);
		System.out.println(eventCounterService.incrementAndGetBookCount(event));
		System.out.println(eventCounterService.incrementAndGetBookCount(event));
		assertEquals(count + 3, eventCounterService.incrementAndGetBookCount(event));
	}
	
	@Test
	public void testGetByNameCounter() {
		EventCounter eventCounter = eventCounterService.getAll().get(0);
		System.out.println("Testing by name counter for event: " + eventCounter.getEvent().getName());
		
		
		System.out.println(eventCounter.getByNameCount());
		assertEquals(1, eventCounter.getByNameCount());
	}

	@Test
	public void testGetPriceCounter() {
		EventCounter eventCounter = eventCounterService.getAll().get(1);
		System.out.println("Testing price counter for event: " + eventCounter.getEvent().getName());
		
		System.out.println(eventCounter.getPriceCount());
		assertEquals(4, eventCounter.getPriceCount());
	}

	@Test
	public void testBookCounter() {
		EventCounter eventCounter = eventCounterService.getAll().get(1);
		System.out.println("Testing book counter for event: " + eventCounter.getEvent().getName());
		
		System.out.println(eventCounter.getBookCount());
		assertEquals(1, eventCounter.getBookCount());
	}
}
