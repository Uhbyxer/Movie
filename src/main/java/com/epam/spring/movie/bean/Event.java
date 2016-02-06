package com.epam.spring.movie.bean;

public class Event extends BaseBean {
	
	private String name;
	
	private int rating;
	
	private double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + " < R: " + rating + " $ " + price + " >";
	}

		
	
}
