package com.epam.spring.movie.bean;


public class User extends NamedBean {

	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return name + " <" + email + ">";
	}
	
}
