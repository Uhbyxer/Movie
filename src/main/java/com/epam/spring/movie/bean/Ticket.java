package com.epam.spring.movie.bean;

import java.time.LocalDateTime;


public class Ticket extends BaseBean {
	
	private Event event;
	
	private LocalDateTime dateTime;
	
	private Auditorium auditorium;
	
	private Integer seat;
	
	private User user;
	
	private Double price;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "" + event.getName() + "/" + auditorium.getName() + "/" + dateTime + "/seat: " + seat 
				+ (user == null ? "" : " by " + user.getEmail()
				+ (price == null ? "" : " $ " + price));
	}
	
}
