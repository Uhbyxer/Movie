package com.epam.spring.movie.service;

import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.dao.TicketDao;

public interface TicketService extends TicketDao {
	
	public void calculatePrice(Ticket ticket);
	
	public void bookTicket(Ticket ticket);
	
	
	
}
