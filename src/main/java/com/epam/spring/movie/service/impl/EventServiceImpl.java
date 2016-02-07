package com.epam.spring.movie.service.impl;

import java.util.List;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.dao.EventDao;
import com.epam.spring.movie.service.EventService;

public class EventServiceImpl implements EventService {
	
	private EventDao eventDao;

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public void create(Event event) {
		eventDao.create(event);
	}

	@Override
	public void remove(Event event) {
		eventDao.remove(event);
		
	}

	@Override
	public List<Event> getAll() {
		return eventDao.getAll();
	}

	@Override
	public Event getById(Integer id) {
		return eventDao.getById(id);
	}

	@Override
	public List<Event> getListByName(String name) {
		return eventDao.getListByName(name);
	}



}
