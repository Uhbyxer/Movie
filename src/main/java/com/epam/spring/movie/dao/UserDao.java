package com.epam.spring.movie.dao;

import java.util.List;

import com.epam.spring.movie.bean.User;

public interface UserDao {
	
	public void create(User user);

	public void remove(User user);

	public List<User> getAll();
	
	public User getById(Integer id);
	
	public List<User> getUsersByName(String name);
	
	public User getUserByEmail(String email);
	
}
