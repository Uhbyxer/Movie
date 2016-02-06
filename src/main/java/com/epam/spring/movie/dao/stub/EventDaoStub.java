package com.epam.spring.movie.dao.stub;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.dao.EventDao;

public class EventDaoStub implements EventDao {
	
	private Map<Integer, Event> holder;
	
	public void setHolder(Map<Integer, Event> holder) {
		this.holder = holder;
	}
	
	@Override
	public List<Event> getAll() {
		return  holder.entrySet()
				.stream()
				.map(p -> p.getValue())
				.collect(Collectors.toList());
	}
	
	@Override
	public void create(Event event) {
		holder.putIfAbsent(event.getId(), event);	
	}

	@Override
	public void remove(Event event) {
		holder.remove(event.getId());
	}

	@Override
	public Event getById(Integer id) {
		return holder.get(id);
	}

	@Override
	public List<Event> getEventsByName(String name) {
		return  holder.entrySet()
				.stream()
				.filter(p -> p.getValue().getName().compareToIgnoreCase(name) == 0)
				.map(p -> p.getValue())
				.collect(Collectors.toList());
	}

}
