package com.epam.spring.movie.dao.stub;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.epam.spring.movie.bean.Auditorium;

import com.epam.spring.movie.dao.AuditoriumDao;

public class AuditoriumDaoStub implements AuditoriumDao{
	
	private Map<Integer, Auditorium> holder;

	public void setHolder(Map<Integer, Auditorium> holder) {
		this.holder = holder;
	}
	
	@Override
	public void create(Auditorium auditorium) {
		
		
	}

	@Override
	public void remove(Auditorium auditorium) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Auditorium> getAll() {
		return  holder.entrySet()
				.stream()
				.map(p -> p.getValue())
				.collect(Collectors.toList());
	}

	@Override
	public Auditorium getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auditorium> getEventsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
