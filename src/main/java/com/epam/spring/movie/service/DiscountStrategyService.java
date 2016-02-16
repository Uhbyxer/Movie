package com.epam.spring.movie.service;


import java.util.List;
import com.epam.spring.movie.bean.DiscountStrategy;
import com.epam.spring.movie.bean.Ticket;


public interface DiscountStrategyService {
	
	public void create(DiscountStrategy discountStrategy);

	public void remove(DiscountStrategy discountStrategy);

	public List<DiscountStrategy> getAll();
	
	public DiscountStrategy getById(Integer id);

	public List<DiscountStrategy> getListByName(String name);

	public DiscountStrategy getBestDiscountStrategy(Ticket ticket, long countOfTicketsForUser);

}
