package com.epam.spring.movie.dao;



import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.EventCounter;

public interface EventCounterDao extends BaseDao<EventCounter>{
	
	public EventCounter getByEvent(Event event);
	
}
