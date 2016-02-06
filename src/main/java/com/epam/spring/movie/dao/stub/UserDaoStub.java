package com.epam.spring.movie.dao.stub;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.dao.UserDao;

public class UserDaoStub implements UserDao {

	private Map<Integer, User> holder;
	
	public void setHolder(Map<Integer, User> holder) {
		this.holder = holder;
	}

	@Override
	public void create(User user) {
		holder.putIfAbsent(user.getId(), user);	
	}

	@Override
	public void remove(User user) {
		holder.remove(user.getId());
		
	}	
	
	@Override
	public List<User> getAll() {
		
		return  holder.entrySet()
				.stream()
				.map(p -> p.getValue())
				.collect(Collectors.toList());
	}

	@Override
	public User getById(Integer id) {
		return holder.get(id);
	}

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
