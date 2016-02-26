package com.epam.spring.movie.dao.stub;

import com.epam.spring.movie.bean.Event;

import com.epam.spring.movie.dao.EventDao;

public class EventDaoStub extends BaseNamedDaoStub<Event> implements EventDao  {

	@Override
	public Event getByName(String name) {
		return 	holder.entrySet()
				.stream()
				.filter(p -> p.getValue().getName().compareToIgnoreCase(name) == 0)
				.map(p -> p.getValue())
				.findFirst()
				.orElse(null);
	}

	@Override
	public double getPrice(Event event) {
		return event.getPrice();
	}
	
}
