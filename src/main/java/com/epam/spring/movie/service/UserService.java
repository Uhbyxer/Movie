package com.epam.spring.movie.service;



import java.util.List;

import com.epam.spring.movie.bean.User;



public interface UserService {

	public User getUserByEmail(String email);

	public void create(User user);
	
	public void remove(User user);
	
	public List<User> getAll();
	
	public User getById(Integer id);

	public List<User> getListByName(String name);
	

}
