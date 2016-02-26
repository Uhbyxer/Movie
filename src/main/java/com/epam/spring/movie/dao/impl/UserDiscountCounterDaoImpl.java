package com.epam.spring.movie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.spring.movie.bean.DiscountStrategy;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.bean.UserDiscountCounter;
import com.epam.spring.movie.dao.DiscountStrategyDao;
import com.epam.spring.movie.dao.UserDao;
import com.epam.spring.movie.dao.UserDiscountCounterDao;

public class UserDiscountCounterDaoImpl extends BaseDaoImpl<UserDiscountCounter> implements UserDiscountCounterDao {

	private UserDao userDao;
	
	private DiscountStrategyDao discountStrategyDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setDiscountStrategyDao(DiscountStrategyDao discountStrategyDao) {
		this.discountStrategyDao = discountStrategyDao;
	}

	@Override
	protected UserDiscountCounter getBeanFromResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserDiscountCounter getByUserAndDiscount(User user, DiscountStrategy discountStrategy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int incrementAndGetCount(User user, DiscountStrategy discountStrategy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCountByDiscount(DiscountStrategy discountStrategy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create(UserDiscountCounter userDiscountCounter) {
		// TODO Auto-generated method stub
		
	}

	public UserDiscountCounterDaoImpl() {
		super("discount_counter");
	}


}
