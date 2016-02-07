package com.epam.spring.movie.bean;

public class DiscountStrategy extends NamedBean {
	
	public static final String EVERY_TICKET_DISCOUNT = "every-ticket-discount";
	
	public static final String BIRTHDAY_DISCOUNT = "birthday-discount";
	
	private double mainDiscount;
	
	private double everyTicketDiscount;
	
	private int everyTicketNumber;

	public double getMainDiscount() {
		return mainDiscount;
	}

	public void setMainDiscount(double mainDiscount) {
		this.mainDiscount = mainDiscount;
	}

	public double getEveryTicketDiscount() {
		return everyTicketDiscount;
	}

	public void setEveryTicketDiscount(double everyTicketDiscount) {
		this.everyTicketDiscount = everyTicketDiscount;
	}

	public int getEveryTicketNumber() {
		return everyTicketNumber;
	}

	public void setEveryTicketNumber(int everyTicketNumber) {
		this.everyTicketNumber = everyTicketNumber;
	}
	
	@Override
	public String toString() {
		if(EVERY_TICKET_DISCOUNT.equals(name)) {
			return EVERY_TICKET_DISCOUNT + ": " + everyTicketDiscount + " % per " + everyTicketNumber + " ticket";
				
		} else {
			return BIRTHDAY_DISCOUNT + ": " + mainDiscount + " %";
		}
		
	}
	
	public double getValue() {
		return ( EVERY_TICKET_DISCOUNT.equals(name) ? everyTicketDiscount : mainDiscount);
	}
	
}
