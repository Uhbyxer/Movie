package com.epam.spring.movie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.dao.EventDao;

public class EventDaoImpl extends BaseNamedDaoImpl<Event> implements EventDao {

	private static final String INSERT_RECORD = "insert into event (name, rating, price) VALUES (?,?,?)";


	@Override
	protected Event getBeanFromResultSet(ResultSet rs) throws SQLException {
		Event event = new Event();
		event.setId(rs.getInt("id"));
		event.setName(rs.getString("name"));
		event.setPrice(rs.getDouble("price"));
		event.setRating(rs.getInt("rating"));
		return event;
	}
	
	
	
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
	public Event getByName(String name) {
		try {

			return jdbcTemplate.queryForObject(getByNameSql, new Object[] { name },

			new RowMapper<Event>() {
				public Event mapRow(ResultSet rs, int rowNum) throws SQLException {

					return getBeanFromResultSet(rs);

				}
			});

		} catch (Exception e) {

			// no rows
			return null;
		}
	}

	public EventDaoImpl() {
		super("event");
	}
	

}
