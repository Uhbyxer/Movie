package com.epam.spring.movie.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.spring.movie.bean.Auditorium;
import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.service.AuditoriumService;
import com.epam.spring.movie.service.EventService;

@Controller
//@RequestMapping(value = { "/", "/events" })
public class HomeController {

	@Autowired
	private EventService eventService;
	
	@Autowired 
	private AuditoriumService auditoriumService;

	
	//..., headers = "accept/text/*"
	//..., params = {"find=ByMake", "form"}
	
//	@RequestMapping(value = { "/", "/events" }, method = RequestMethod.GET)
//	public String getAllEvents(Model model) {
//		List<Event> events = eventService.getAll();
//		model.addAttribute("events", events);
//		return "events";
//	}
//	

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView getAllEvents(HttpServletRequest request) {
		
		//String foo = request.getParameter("foo");

		ModelAndView mav = new ModelAndView("home");
		
		List<Event> events = eventService.getAll();
		mav.addObject("events", events);
		
		List<Auditorium> auditoriums = auditoriumService.getAll();
		mav.addObject("auditoriums", auditoriums);
		
		return mav;
	}

	
}
