package com.epam.spring.movie.bean;

import java.time.LocalDateTime;


public class Booking extends BaseBean {
	
	private Event event;
	
	private LocalDateTime dateTime;
	
	private Auditorium auditorium;
	
	private Integer seat;
	
	private boolean booked;
	
	private User user;

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

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "" + event + "/" + auditorium + "/" + dateTime + "/seat: " + seat + "booked: " + booked 
				+ (user == null ? "" : " by " + user.getEmail());
	}
	
}
