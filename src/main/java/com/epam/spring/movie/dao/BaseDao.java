package com.epam.spring.movie.dao;

import java.util.List;



public interface BaseDao<T> {
	
	public void create(T user);

	public void remove(T user);

	public List<T> getAll();
	
	public T getById(Integer id);
	

}
