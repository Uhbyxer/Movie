package com.epam.spring.movie.service;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.spring.movie.bean.Assignment;
import com.epam.spring.movie.bean.Auditorium;


public interface AssignmentService {

	public boolean isAssigned(Auditorium auditorium, LocalDateTime dateTime);

	public void create(Assignment assignment);
	
	public void remove(Assignment assignment);

	public List<Assignment> getAll();

	public Assignment getById(Integer id);

}
