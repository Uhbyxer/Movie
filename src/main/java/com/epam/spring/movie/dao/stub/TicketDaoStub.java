package com.epam.spring.movie.dao.stub;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.dao.TicketDao;

public class TicketDaoStub extends BaseDaoStub<Ticket> implements TicketDao  {

	@Override
	public List<Ticket> getTicketsForEvent(Event event, LocalDateTime dateTime) {
		return  holder.entrySet()
				.stream()
				//.filter(p -> p.getValue().getEvent().equals(event) && p.getValue().getDateTime().equals(dateTime))
				.filter(p -> p.getValue().getEvent().equals(event))
				.filter(p -> p.getValue().getDateTime().equals(dateTime))
				.map(p -> p.getValue())
				.collect(Collectors.toList());
	}
	

	@Override
	public long getCountOfTicketsForUser(User user) {
		
		return 	holder.entrySet()
				.stream()
				.filter(p -> p.getValue().getUser().equals(user))
				.count();

	
	}

}
