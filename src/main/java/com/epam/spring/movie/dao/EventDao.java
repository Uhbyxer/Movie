package com.epam.spring.movie.dao;

import java.util.List;

import com.epam.spring.movie.bean.Event;



public interface EventDao {
	public void create(Event event);

	public void remove(Event event);
	
	public List<Event> getAll();
	
	public Event getById(Integer id);
	
	public List<Event> getEventsByName(String name);

}
