package com.epam.spring.movie.dao;

import java.util.List;

import com.epam.spring.movie.bean.User;

public interface UserDao extends BaseDao<User> {
		
	public List<User> getUsersByName(String name);
	
	public User getUserByEmail(String email);
	
}
