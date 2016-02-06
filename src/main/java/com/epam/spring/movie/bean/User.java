package com.epam.spring.movie.bean;


public class User {
	private Integer id;
	private String name;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	
	@Override
	public boolean equals(Object other) {
		if(other == null || id == null) 
			return false;
		
		if (this == other)
			return true;
		
		if(other instanceof User)
			return id.equals(((User) other).id);
		
		return false;
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
	
}
