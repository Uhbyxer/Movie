package com.epam.spring.movie.service;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.spring.movie.bean.Auditorium;
import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.bean.User;


public interface TicketService {
	
	public List<Ticket> getTicketsForEvent(Event event, LocalDateTime dateTime);

	public void create(Ticket ticket);

	public void remove(Ticket ticket);

	public List<Ticket> getAll();

	public Ticket getById(Integer id);
	
	public long getCountOfTicketsForUser(User user);

	public void calculatePrice(Ticket ticket);

	public boolean isBooked(LocalDateTime dateTime, Auditorium auditorium, Integer seat);
	
	public List<Ticket> getTicketsForUser(User user);
	
	public void bookTicket(Ticket ticket);
		
}
