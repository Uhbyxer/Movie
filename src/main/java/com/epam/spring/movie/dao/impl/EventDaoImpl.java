package com.epam.spring.movie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.dao.EventDao;

public class EventDaoImpl implements EventDao {
	private static final String GET_ALL_RECORDS = "select * from event"; 
	private static final String GET_BY_ID = "select * from event where id = ?"; 
	private static final String GET_BY_NAME = "select * from event where lower(name) = lower(?)";
	private static final String INSERT_RECORD = "insert into event (name, rating, price) VALUES (?,?,?)";
	private static final String DELETE_RECORD = "delete from event where id = ?";
	
	private Event getEventFromResultSet(ResultSet rs) throws SQLException {
		Event event = new Event();
		event.setId(rs.getInt("id"));
		event.setName(rs.getString("name"));
		event.setPrice(rs.getDouble("price"));
		event.setRating(rs.getInt("rating"));
		return event;
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void create(Event event) {
		jdbcTemplate.update(
				INSERT_RECORD,
				event.getName(),
				event.getPrice(),
				event.getRating()
		);
		
	}

	@Override
	public void remove(Event event) {
		jdbcTemplate.update(
				DELETE_RECORD,
				event.getId()
		);
		
	}

	@Override
	public List<Event> getAll() {
		return  jdbcTemplate.query(GET_ALL_RECORDS, new RowMapper<Event>() {
			
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {

				return getEventFromResultSet(rs);
				
			}

		});
	}

	@Override
	public Event getById(Integer id) {
		try {

			return jdbcTemplate.queryForObject(GET_BY_ID, new Object[] { id },

			new RowMapper<Event>() {
				public Event mapRow(ResultSet rs, int rowNum) throws SQLException {

					return getEventFromResultSet(rs);

				}
			});

		} catch (Exception e) {

			// no rows
			return null;
		}
	}

	@Override
	public List<Event> getListByName(String name) {
		return  jdbcTemplate.query(GET_BY_NAME, new Object[] { name }, new RowMapper<Event>() {
			
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {

				return getEventFromResultSet(rs);
				
			}

		});
	}

	@Override
	public Event getByName(String name) {
		try {

			return jdbcTemplate.queryForObject(GET_BY_NAME, new Object[] { name },

			new RowMapper<Event>() {
				public Event mapRow(ResultSet rs, int rowNum) throws SQLException {

					return getEventFromResultSet(rs);

				}
			});

		} catch (Exception e) {

			// no rows
			return null;
		}
	}

}
