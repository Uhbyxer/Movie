package com.epam.spring.movie.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class User extends NamedBean {

	private String email;
	
	private LocalDate birth;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getBirth() {
		return birth;
	}
	
	public void setBirthDate(java.util.Date date) {
		birth = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
	}
	
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return name + " <" + email + ">" 
					+ (birth == null ? "" : " (birth: " + birth + ")");
	}
	
}
