package com.epam.spring.movie.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.spring.movie.service.TicketService;

@Aspect
@Component
public class LuckyTicketAspect {
	
	@Autowired
	private TicketService ticketService;

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@Pointcut("execution(* com.epam.spring.movie.service.TicketService.bookTicket(..))")
	private void bookTicket() {}
	
	
	//@Around("bookTicket() && args(user,ticket)")
	
	
}
