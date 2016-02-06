package com.epam.spring.movie.dao.stub;

import java.util.List;

import java.util.stream.Collectors;

import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.dao.UserDao;

public class UserDaoStub  extends BaseDaoStub<User> implements UserDao {

	@Override
	public List<User> getUsersByName(String name) {
		
		return  holder.entrySet()
						.stream()
						.filter(p -> p.getValue().getName().compareToIgnoreCase(name) == 0)
						.map(p -> p.getValue())
						.collect(Collectors.toList());
	}

	@Override
	public User getUserByEmail(String email) {
	
		return 	holder.entrySet()
				.stream()
				.filter(p -> p.getValue().getEmail().compareToIgnoreCase(email) == 0)
				.map(p -> p.getValue())
				.findFirst()
				.orElse(null);
	}


	
}
