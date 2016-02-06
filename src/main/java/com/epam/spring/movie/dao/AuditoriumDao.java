package com.epam.spring.movie.dao;

import java.util.List;

import com.epam.spring.movie.bean.Auditorium;


public interface AuditoriumDao extends BaseDao<Auditorium> {
		
	public List<Auditorium> getEventsByName(String name);

}
