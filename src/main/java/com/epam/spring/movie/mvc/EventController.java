package com.epam.spring.movie.mvc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.service.EventService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	
	@RequestMapping(value = { "/", "/events" }, method = RequestMethod.GET)
	public String getAllEvents(Model model) {
		List<Event> events = eventService.getAll();
		model.addAttribute("events", events);
		return "events";
	}
}
