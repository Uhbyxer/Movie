package com.epam.spring.movie.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.service.TicketService;
import com.epam.spring.movie.service.UserService;

@Controller
public class TicketPdfController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/admin-tickets-pdf")
    public ModelAndView downloadExcel() {
        // create some sample data
		
		User user = userService.getById(1);
        List<Ticket> tickets = ticketService.getTicketsForUser(user);
        
		ModelAndView mav = new ModelAndView("ticketsPdfView");
		mav.addObject("tickets", tickets);
		mav.addObject("user", user);        

		return mav;
		
        // return a view which will be resolved by an excel view resolver
       // return new ModelAndView("pdfView", "listBooks", listBooks);
    }
	
	
}
