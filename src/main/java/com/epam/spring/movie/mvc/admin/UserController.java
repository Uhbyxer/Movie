package com.epam.spring.movie.mvc.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.spring.movie.bean.Auditorium;
import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.Ticket;
import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.dao.UserDao;
import com.epam.spring.movie.service.AuditoriumService;
import com.epam.spring.movie.service.EventService;
import com.epam.spring.movie.service.TicketService;
import com.epam.spring.movie.service.UserService;

@Controller
public class UserController {
	private static int EVENTS_PER_PAGE = 12;

	@Autowired
	private UserService userService;
	
	@Autowired 
	private AuditoriumService auditoriumService;
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("/admin-users")
	public ModelAndView getUsers(HttpServletRequest request) {
		
//		int eventsCount = eventService.getCount();
		
		//ceil  int pages count
///		int pages = (eventsCount - 1) / EVENTS_PER_PAGE + 1;
		
//		String pageParam = request.getParameter("page");
//		int page = 1;
//		if(pageParam != null ) 
//				page = Integer.parseInt(pageParam);

		ModelAndView mav = new ModelAndView("admin-users");
//		mav.addObject("pages", pages);
//		mav.addObject("page", page);
		
		List<User> users = userService.getAll();
		mav.addObject("users", users);
		
		List<Auditorium> auditoriums = auditoriumService.getAll();
		mav.addObject("auditoriums", auditoriums);
		
		return mav;
	}

	
	@RequestMapping(value = "/admin-users/{id}")
	public ModelAndView getUserById(@PathVariable Integer id) {
		
		User user = userService.getById(id);
		
		List<Ticket> tickets = ticketService.getTicketsForUser(user);
		
		ModelAndView mav = new ModelAndView("admin-user");
		mav.addObject("user", user);
		mav.addObject("tickets", tickets);
		
		return mav;
	}
	
	
	
}
