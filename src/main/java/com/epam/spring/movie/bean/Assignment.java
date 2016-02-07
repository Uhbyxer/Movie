package com.epam.spring.movie.bean;

import java.time.LocalDateTime;

public class Assignment extends BaseBean {
	
	private Event event;
	
	private LocalDateTime dateTime;
	
	private Auditorium auditorium;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}
	
	@Override
	public String toString() {
		return auditorium.getName() + "[ " + event.getName() + "] on " + dateTime;
	}
	
}
