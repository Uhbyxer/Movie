package com.epam.spring.movie.dao;

import com.epam.spring.movie.bean.Event;


public interface EventDao extends BaseDao<Event>, HasNameDao<Event> {
	public Event getByName(String name);
}
