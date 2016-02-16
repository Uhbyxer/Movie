package com.epam.spring.movie.bean;

public class EventCounter extends BaseBean {
	
	private Event event;
	
	private Integer byNameCount;
	
	private Integer priceCount;
	
	private Integer bookCount;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Integer getByNameCount() {
		return byNameCount;
	}

	public void setByNameCount(Integer byNameCount) {
		this.byNameCount = byNameCount;
	}

	public Integer getPriceCount() {
		return priceCount;
	}

	public void setPriceCount(Integer priceCount) {
		this.priceCount = priceCount;
	}

	public Integer getBookCount() {
		return bookCount;
	}

	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}

	@Override
	public String toString() {
		return "Counter for " + event.getName() + ": byNameCount=" + byNameCount + ", priceCount=" + priceCount
				+ ", bookCount=" + bookCount;
	}
	
	
}
