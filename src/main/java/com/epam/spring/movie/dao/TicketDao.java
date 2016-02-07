package com.epam.spring.movie.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;

public interface TicketDao extends BaseDao<Ticket> {
	
	public List<Ticket> getTicketsForEvent(Event event, LocalDateTime dateTime);
	
}
