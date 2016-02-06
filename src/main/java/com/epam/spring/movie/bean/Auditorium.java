package com.epam.spring.movie.bean;

import java.util.Set;

public class Auditorium extends NamedBean {

	private Integer numberOfSeats;
	
	private Set<Integer> vipSeats;

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Set<Integer> getVipSeats() {
		return vipSeats;
	}

	public void setVipSeats(Set<Integer> vipSeats) {
		this.vipSeats = vipSeats;
	}
	
	@Override
	public String toString() {
		return name;
		
	}
	
	
}
