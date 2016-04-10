package com.epam.spring.movie.service;

import java.util.List;

import com.epam.spring.movie.bean.Event;


public interface EventService {
	
	public void create(Event event);

	public void remove(Event event);

	public List<Event> getAll();
	
	public Event getById(Integer id);

	public List<Event> getListByName(String name);
	
	public Event getByName(String name);
	
	public double getPrice(Event event);
	
	public List<Event> getEventsForPage(int pageNumber, int rowsPerPage);
	
	public int getCount();
	
}	
