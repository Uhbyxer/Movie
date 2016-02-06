package com.epam.spring.movie.dao;

import java.util.List;

import com.epam.spring.movie.bean.Event;

public interface EventDao extends BaseDao<Event> {
	
	public List<Event> getEventsByName(String name);

}
