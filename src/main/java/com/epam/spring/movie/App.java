package com.epam.spring.movie;


import java.time.LocalDateTime;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.service.AuditoriumService;
import com.epam.spring.movie.service.DiscountStrategyService;
import com.epam.spring.movie.service.EventService;
import com.epam.spring.movie.service.TicketService;
import com.epam.spring.movie.service.UserService;



public class App {
	

	private UserService userService;
	
	private EventService eventService;
	
	private AuditoriumService auditoriumService;
	
	private TicketService ticketService;
	
	private DiscountStrategyService discountStrategyService;
	
	private Ticket newTicketFirst;
	
	private Ticket newTicketSecond;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	

	public AuditoriumService getAuditoriumService() {
		return auditoriumService;
	}

	public void setAuditoriumService(AuditoriumService auditoriumService) {
		this.auditoriumService = auditoriumService;
	}

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public DiscountStrategyService getDiscountStrategyService() {
		return discountStrategyService;
	}

	public void setDiscountStrategyService(DiscountStrategyService discountStrategyService) {
		this.discountStrategyService = discountStrategyService;
	}
	
	public Ticket getNewTicketFirst() {
		return newTicketFirst;
	}

	public void setNewTicketFirst(Ticket newTicketFirst) {
		this.newTicketFirst = newTicketFirst;
	}

	public Ticket getNewTicketSecond() {
		return newTicketSecond;
	}

	public void setNewTicketSecond(Ticket newTicketSecond) {
		this.newTicketSecond = newTicketSecond;
	}

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app = (App) ctx.getBean("app");
		
		System.out.println("=============================== User service ===============================");
		
		
		UserService userService = app.getUserService();

		System.out.println("User by id = 1 : " + userService.getById(1));
	
		User user = userService.getUserByEmail("bruce_willis@gmail.com");
		System.out.println("User by email (bruce_willis@gmail.com)   : " + user);
		
		System.out.println("\nBy name = john doe :");
		userService.getListByName("john doe").forEach(System.out::println);
		
		System.out.println("\nAll :");
		userService.getAll().forEach(System.out::println);
		
		System.out.println("\nRemove Bruce:");
		userService.remove(user);
		userService.getAll().forEach(System.out::println);
		
		System.out.println("\nAdd Bruce:");
		userService.create(user);
		userService.getAll().forEach(System.out::println);
		
		
		System.out.println("=============================== Event service ===============================");
		
		EventService eventService = app.getEventService();
		
		Event event = eventService.getById(1);
		System.out.println("Event by id = 1 : " + event);
	
		System.out.println("\nBy name = dead pool :");
		eventService.getListByName("dead pool").forEach(System.out::println);
		
		System.out.println("\nAll :");
		eventService.getAll().forEach(System.out::println);
		
		System.out.println("\nRemove Pulp Fiction:");
		eventService.remove(event);
		eventService.getAll().forEach(System.out::println);
		
		System.out.println("\nAdd Pulp Fiction:");
		eventService.create(event);
		eventService.getAll().forEach(System.out::println);		
		
		System.out.println("=============================== Auditorium service ===============================");
		
		AuditoriumService auditoriumService = app.getAuditoriumService();
		System.out.println("\nAll :");
		auditoriumService.getAll().forEach(System.out::println);		
		
		System.out.println("=============================== Ticket service ===============================");
		TicketService ticketService = app.getTicketService();
		System.out.println("\nAll :");
		ticketService.getAll().forEach(System.out::println);		
		
		LocalDateTime dt = LocalDateTime.of(2016, 03, 01, 18, 30);
		System.out.println("\nFor event :" + event.getName() + " and time: " + dt);
		ticketService.getTicketsForEvent(event, dt).forEach(System.out::println);
		
		System.out.println("=============================== Discount strategy ===============================");
		DiscountStrategyService discountStrategyService = app.getDiscountStrategyService();
		System.out.println("Discount strategies :");
		discountStrategyService.getAll().forEach(System.out::println);
				
		
		System.out.println("=============================== Buy Ticket ===============================");
		System.out.println("Tiket:");
		System.out.println(app.newTicketFirst);
		
		if(ticketService.isBooked(app.newTicketFirst.getDateTime(), app.newTicketFirst.getAuditorium(), app.newTicketFirst.getSeat())) {
			
			System.out.println("BOOKED ALREADY !!!");
			
		} else {
			System.out.println("IS FREE ");
			
			ticketService.calculatePrice(app.newTicketFirst);
			ticketService.create(app.newTicketFirst);
			
			System.out.println("\nBill details: ");
			System.out.println(app.newTicketFirst.getBillDetails());
		}
		
		System.out.println("Try again to buy previous ticket: ");
		if(ticketService.isBooked(app.newTicketFirst.getDateTime(), app.newTicketFirst.getAuditorium(), app.newTicketFirst.getSeat())) {
			
			System.out.println("BOOKED ALREADY !!!");
			
		} else {
			System.out.println("IS FREE ");
			
			ticketService.calculatePrice(app.newTicketFirst);
			ticketService.create(app.newTicketFirst);
			
			System.out.println("\nBill details: ");
			System.out.println(app.newTicketFirst.getBillDetails());
		}
		
		System.out.println("\nYour booked tickets:");
		ticketService.getTicketsForUser(app.newTicketFirst.getUser()).forEach(System.out::println);
		
		
		
		
		
	}
}
