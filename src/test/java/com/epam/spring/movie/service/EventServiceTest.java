package com.epam.spring.movie.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.spring.movie.AbstractTestCase;
import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.service.EventService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EventServiceTest extends AbstractTestCase {
	
	public static int testCounter = 0;
	public static final String NAME = "Scary movie";
	
	@Autowired
	private EventService eventService;
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("\n*********************************************** EventService Tests --->");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("\nTest # " + ++testCounter);
	}

	@Test
	public void testCreate() {
		Event event = new Event();
		event.setId(1000);
		event.setName(NAME);
		event.setPrice(500);
		event.setRating(5);
		
		int size = eventService.getAll().size();
		System.out.println("Create event: " + event);
		eventService.create(event);
		assertEquals(size + 1, eventService.getAll().size());
	}

	@Test
	public void testRemove() {
		List<Event> events = eventService.getAll();
		Event event = events.get(events.size()-1);
		
		System.out.println("Removing: " + event);
		eventService.remove(event);
		
		assertEquals(events.size() - 1, eventService.getAll().size());
		
	}

	@Test
	public void testGetAll() {
		List<Event> events = eventService.getAll();
		System.out.println("All events:");
		events.forEach(System.out::println);
		assertTrue(events.size() > 0);
	}

	@Test
	public void testGetById() {
		Event event = eventService.getById(1);
		System.out.println("Event with id = 1 : " + event);
		assertEquals(event.getId(), Integer.valueOf(1));
		
	}

	@Test
	public void testGetListByName() {
		System.out.println("Event by name = " + NAME);
		List<Event> events =  eventService.getListByName(NAME);
		events.forEach(System.out::println);	
		for (Event event : events) {
			assertEquals(event.getName(), NAME);
		}
	}
	
	@Test
	public void testGetByName() {
		Event event = eventService.getByName(NAME);
		System.out.println("Event with name =  : " + NAME);
		System.out.println(event);
		assertEquals(event.getName(), NAME);
		
	}

}
