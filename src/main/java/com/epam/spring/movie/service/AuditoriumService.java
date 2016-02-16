package com.epam.spring.movie.service;

import java.util.List;

import com.epam.spring.movie.bean.Auditorium;


public interface AuditoriumService {

	public void create(Auditorium auditorium);

	public void remove(Auditorium auditorium);

	public List<Auditorium> getAll();
		
	public Auditorium getById(Integer id);

	public List<Auditorium> getListByName(String name);

}
