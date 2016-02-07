package com.epam.spring.movie.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.spring.movie.bean.Auditorium;
import com.epam.spring.movie.bean.DiscountStrategy;
import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.dao.TicketDao;
import com.epam.spring.movie.service.TicketService;

public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;
	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	public List<Ticket> getTicketsForEvent(Event event, LocalDateTime dateTime) {
		return ticketDao.getTicketsForEvent(event, dateTime);
	}

	@Override
	public void create(Ticket ticket) {
		ticketDao.create(ticket);
		
	}

	@Override
	public void remove(Ticket ticket) {
		ticketDao.remove(ticket);
		
	}

	@Override
	public List<Ticket> getAll() {
		return ticketDao.getAll();
	}

	@Override
	public Ticket getById(Integer id) {
		return ticketDao.getById(id);
	}

	@Override
	public long getCountOfTicketsForUser(User user) {
		return ticketDao.getCountOfTicketsForUser(user);
	}

	@Override
	public void calculatePrice(Ticket ticket) {
		
		if(ticket.getEvent() == null) return;
		
		double price = ticket.getEvent().getPrice();
		ticket.setPriceBase(price);
		
		price +=  ((double) ticket.getEvent().getRating()) / 10.0 * price;
		ticket.setPriceWithRaiting(price);
		
		Auditorium auditorium = ticket.getAuditorium();
		if(auditorium != null) {
			if (auditorium.getVipSeats() != null && auditorium.getVipSeats().contains(ticket.getSeat())) {
				price *= 2;
			}
		}
		ticket.setPriceWithVip(price);
		
		DiscountStrategy discountStrategy = ticket.getDiscountStrategy();
		if(discountStrategy != null) {
			ticket.setDiscountStrategy(discountStrategy);
			double discount = discountStrategy.getValue();
			price *= (100.0 - discount) / 100 ;
			
			ticket.setDiscount(discount);
		}
		
		ticket.setPrice(price);
	}

	@Override
	public void bookTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}
	
	

}
