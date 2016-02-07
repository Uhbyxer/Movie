package com.epam.spring.movie;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.User;

import com.epam.spring.movie.service.AuditoriumService;
import com.epam.spring.movie.service.EventService;
import com.epam.spring.movie.service.UserService;



public class App {
	

	private UserService userService;
	
	private EventService eventService;
	
	private AuditoriumService auditoriumService;
	
	
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
		
		
	}
}
