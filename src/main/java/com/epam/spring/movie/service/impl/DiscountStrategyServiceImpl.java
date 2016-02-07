package com.epam.spring.movie.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import com.epam.spring.movie.bean.DiscountStrategy;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.dao.DiscountStrategyDao;
import com.epam.spring.movie.service.DiscountStrategyService;
import com.epam.spring.movie.service.TicketService;

public class DiscountStrategyServiceImpl implements DiscountStrategyService {

	private DiscountStrategyDao discountStrategyDao;
	
	private TicketService ticketService;
	
	public void setDiscountStrategyDao(DiscountStrategyDao discountStrategyDao) {
		this.discountStrategyDao = discountStrategyDao;
	}
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@Override
	public void create(DiscountStrategy discountStrategy) {
		discountStrategyDao.create(discountStrategy);
		
	}

	@Override
	public void remove(DiscountStrategy discountStrategy) {
		discountStrategyDao.remove(discountStrategy);
		
	}

	@Override
	public List<DiscountStrategy> getAll() {
		return discountStrategyDao.getAll();
	}

	@Override
	public DiscountStrategy getById(Integer id) {
		
		return discountStrategyDao.getById(id);
	}


	@Override
	public List<DiscountStrategy> getListByName(String name) {
		return discountStrategyDao.getListByName(name);
	}



	@Override
	public DiscountStrategy getBestDiscountStrategy(Ticket ticket) {
		
		DiscountStrategy res = null;
		
		if(ticket == null || ticket.getUser() == null)
			return res;
		
		LocalDateTime eventDate = ticket.getDateTime();
		LocalDate userDate = ticket.getUser().getBirth();
		
		ticket.getDateTime().getMonth();
		ticket.getDateTime().getDayOfMonth();
		
		double max = 0;
		
		for(DiscountStrategy discount : getAll()) {
			
			if(DiscountStrategy.BIRTHDAY_DISCOUNT.equals(discount.getName())) {
				
				if(eventDate != null && userDate != null) {
					if(eventDate.getMonthValue() == userDate.getMonthValue() 
							&& eventDate.getDayOfMonth() == userDate.getDayOfMonth()) {
						
						if(discount.getMainDiscount() > max) {
							max = discount.getMainDiscount();
							res = discount;
						}
						
					}
				}
				
			} else {
				
				double count = 1.0 + ticketService.getCountOfTicketsForUser(ticket.getUser());
				if( count % discount.getEveryTicketDiscount() == 0 ) {
					
					if(discount.getEveryTicketDiscount() > max) {
						max = discount.getEveryTicketDiscount();
						res = discount;
					}
				}
				
			}
		}
		
		return res;
	} 

	
	
}
