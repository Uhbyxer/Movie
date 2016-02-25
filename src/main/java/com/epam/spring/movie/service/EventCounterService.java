package com.epam.spring.movie.service;

import java.util.List;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.EventCounter;

public interface EventCounterService {
	
	public void create(EventCounter eventCounter);

	public void remove(EventCounter eventCounter);

	public List<EventCounter> getAll();
	
	public EventCounter getById(Integer id);
	
	public EventCounter getByEvent(Event event);
	
	public int incrementAndGetByNameCount(Event event);
	
	public int incrementAndGetPriceCount(Event event);

	public int incrementAndGetBookCount(Event event);
	
	public void update(EventCounter eventCounter);

}
