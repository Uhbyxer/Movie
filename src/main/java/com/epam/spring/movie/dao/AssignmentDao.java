package com.epam.spring.movie.dao;

import java.time.LocalDateTime;

import com.epam.spring.movie.bean.Assignment;
import com.epam.spring.movie.bean.Auditorium;


public interface AssignmentDao extends BaseDao<Assignment> {
	
	public boolean isAssigned(Auditorium auditorium, LocalDateTime dateTime);

}
