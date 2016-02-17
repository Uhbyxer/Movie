package com.epam.spring.movie.service;

import java.util.List;
import com.epam.spring.movie.bean.DiscountStrategy;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.bean.UserDiscountCounter;

public interface UserDiscountCounterService {
	
	public void create(UserDiscountCounter userDiscountCounter);

	public void remove(UserDiscountCounter userDiscountCounter);

	public List<UserDiscountCounter> getAll();
	
	public UserDiscountCounter getById(Integer id);
	
	public UserDiscountCounter getByUserAndDiscount(User user, DiscountStrategy discountStrategy);
	
	public int incrementAndGetCount(User user, DiscountStrategy discountStrategy);
	
	public int getTotalCountByDiscount(DiscountStrategy discountStrategy);
}
