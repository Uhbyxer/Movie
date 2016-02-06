package com.epam.spring.movie.bean;

import java.util.Set;

public class Auditorium extends BaseBean {
	
	private String name;
	
	private Integer numberOfSeats;
	
	private Set<Integer> vipSeats;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
