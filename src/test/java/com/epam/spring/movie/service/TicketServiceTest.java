package com.epam.spring.movie.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.spring.movie.AbstractTestCase;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.bean.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketServiceTest extends AbstractTestCase {
	public static int testCounter = 0;
	
	@Autowired
	@Qualifier("new_ticket_7")
	private Ticket newTicketFirst;
	
	@Autowired
	private TicketService ticketService;
	
	
	@Autowired
	@Qualifier("user_0")
	private User userFirst;
	
	@Autowired
	@Qualifier("user_0")
	private User userSecond;
	
	@Autowired
	@Qualifier("event_0")
	private Event event;
	
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("\n*********************************************** Ticket Tests --->");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("\nTest # " + ++testCounter);
	}

	@Test
	public void testGetTicketsForEvent() {
		System.out.println("Getting tickets for event: " + newTicketFirst.getEvent());
		System.out.println("For time: " + newTicketFirst.getDateTime());
		List<Ticket> list =  ticketService.getTicketsForEvent(newTicketFirst.getEvent(), newTicketFirst.getDateTime());
		list.forEach(System.out::println);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testToBookTicket() {
		int before  = ticketService.getAll().size();
		
		System.out.println("Try to book ticket: " + newTicketFirst);
		
		ticketService.bookTicket(newTicketFirst);
		
		assertEquals(before + 1, ticketService.getAll().size());
}

	@Test
	public void testGetAll() {
		System.out.println("Get all booked tickets:");
		List<Ticket> list =  ticketService.getAll();
		list.forEach(System.out::println);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testGetCountOfTicketsForUser() {
		System.out.println("Count of tickets bought by User: " + newTicketFirst.getUser());
		long count = ticketService.getCountOfTicketsForUser(newTicketFirst.getUser());
		System.out.println(count);
		assertTrue(count > 0);
	}

	@Test
	public void testIsBooked() {
		System.out.println("Get status of ticket: " + newTicketFirst);
		
		
		boolean booked = ticketService.isBooked(newTicketFirst.getDateTime(), newTicketFirst.getAuditorium(), newTicketFirst.getSeat());
		if(booked) {
			System.out.println("BOOKED ALREADY !!!");
			
		} else {
			System.out.println("IS FREE ");
		}	
		
		assertFalse(booked);
	}

	@Test
	public void testGetTicketsForUser() {
		List<Ticket> list =  ticketService.getTicketsForUser(userFirst);
		System.out.println("All bought tickets for user: " + userFirst.getName());
		System.out.println("Tickets:");
		list.forEach(System.out::println);
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void testCalculatePriceFirstCase() {
		User userFirst = newTicketFirst.getUser();
		
		System.out.println("Calculating price for Ticket");
		System.out.println("User: " + userFirst);
		System.out.println("Event: " + newTicketFirst.getEvent());
		System.out.println("Booking time:" + newTicketFirst.getDateTime());
		long count = ticketService.getCountOfTicketsForUser(userFirst);
		System.out.println("Number tickets user bought before:" + count);
		ticketService.calculatePrice(newTicketFirst);
		System.out.println("\nBill details:");
		System.out.println(newTicketFirst.getBillDetails());
		assertTrue(newTicketFirst.getPrice() > 0);
	}
	
	@Test
	public void testCalculatePriceSecondCase() throws CloneNotSupportedException {
		Ticket ticket = (Ticket) newTicketFirst.clone();
		ticket.setUser(userSecond);
		
		
		System.out.println("Calculating price for Ticket");
		System.out.println("User: " + userSecond);
		System.out.println("Event: " + ticket.getEvent());
		System.out.println("Booking time:" + ticket.getDateTime());
		long count = ticketService.getCountOfTicketsForUser(userSecond);
		System.out.println("Number tickets user bought before:" + count);
		ticketService.calculatePrice(ticket);
		System.out.println("\nBill details:");
		System.out.println(ticket.getBillDetails());
		assertTrue(ticket.getPrice() > 0);
	}
	
	@Test
	public void testCalculatePriceNotRegisteredUser() throws CloneNotSupportedException {
		Ticket ticket = (Ticket) newTicketFirst.clone();
		ticket.setUser(null);
		
		
		System.out.println("Calculating price of Ticket for not registered User");
		
		System.out.println("Event: " + ticket.getEvent());
		System.out.println("Booking time:" + ticket.getDateTime());

		ticketService.calculatePrice(ticket);
		System.out.println("\nBill details:");
		System.out.println(ticket.getBillDetails());
		assertTrue(ticket.getPrice() > 0);
	}}
