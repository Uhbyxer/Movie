package com.epam.spring.movie.dao;

import java.util.List;

import com.epam.spring.movie.bean.Auditorium;


public interface AuditoriumDao {
	public void create(Auditorium auditorium);

	public void remove(Auditorium auditorium);
	
	public List<Auditorium> getAll();
	
	public Auditorium getById(Integer id);
	
	public List<Auditorium> getEventsByName(String name);
}
