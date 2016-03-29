package com.epam.spring.movie.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.service.EventService;

@Controller
//@RequestMapping(value = { "/", "/events" })
public class EventController {

	@Autowired
	private EventService eventService;

	
	//..., headers = "accept/text/*"
	//..., params = {"find=ByMake", "form"}
	
//	@RequestMapping(value = { "/", "/events" }, method = RequestMethod.GET)
//	public String getAllEvents(Model model) {
//		List<Event> events = eventService.getAll();
//		model.addAttribute("events", events);
//		return "events";
//	}
//	

	@RequestMapping(value = { "/", "/events" })
	public ModelAndView getAllEvents(HttpServletRequest request) {
		
		//String foo = request.getParameter("foo");
		
		List<Event> events = eventService.getAll();
		ModelAndView mav = new ModelAndView("events");
		mav.addObject("events", events);
		
		return mav;
	}

	
}
