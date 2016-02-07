package com.epam.spring.movie.dao.stub;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.dao.TicketDao;

public class TicketDaoStub extends BaseDaoStub<Ticket> implements TicketDao  {

	@Override
	public List<Ticket> getTicketsForEvent(Event event, LocalDateTime dateTime) {
		return new ArrayList<Ticket>();
	}

}
