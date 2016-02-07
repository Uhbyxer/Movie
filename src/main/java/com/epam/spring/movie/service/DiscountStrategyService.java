package com.epam.spring.movie.service;

import com.epam.spring.movie.bean.DiscountStrategy;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.dao.DiscountStrategyDao;

public interface DiscountStrategyService extends DiscountStrategyDao {
	
	public DiscountStrategy getBestDiscountStrategy(Ticket ticket, long countOfTicketsForUser); 
	
}
