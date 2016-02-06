package com.epam.spring.movie.dao.stub;

import java.util.List;

import java.util.stream.Collectors;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.dao.EventDao;

public class EventDaoStub extends BaseDaoStub<Event> implements EventDao {
	

	@Override
	public List<Event> getEventsByName(String name) {
		return  holder.entrySet()
				.stream()
				.filter(p -> p.getValue().getName().compareToIgnoreCase(name) == 0)
				.map(p -> p.getValue())
				.collect(Collectors.toList());
	}

}
