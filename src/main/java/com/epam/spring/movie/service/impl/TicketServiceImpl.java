package com.epam.spring.movie.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.dao.TicketDao;
import com.epam.spring.movie.service.TicketService;

public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;
	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	public List<Ticket> getTicketsForEvent(Event event, LocalDateTime dateTime) {
		return ticketDao.getTicketsForEvent(event, dateTime);
	}

	@Override
	public void create(Ticket ticket) {
		ticketDao.create(ticket);
		
	}

	@Override
	public void remove(Ticket ticket) {
		ticketDao.remove(ticket);
		
	}

	@Override
	public List<Ticket> getAll() {
		return ticketDao.getAll();
	}

	@Override
	public Ticket getById(Integer id) {
		return ticketDao.getById(id);
	}

	@Override
	public long getCountOfTicketsForUser(User user) {
		return ticketDao.getCountOfTicketsForUser(user);
	}
	
	

}
