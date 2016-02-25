package com.epam.spring.movie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.epam.spring.movie.bean.Event;
import com.epam.spring.movie.bean.EventCounter;
import com.epam.spring.movie.dao.EventCounterDao;
import com.epam.spring.movie.dao.EventDao;


public class EventCounterDaoImpl extends  BaseDaoImpl<EventCounter> implements EventCounterDao {
	
	private static final String INSERT_RECORD = "insert into event_counter (by_name_count, price_count, book_count) VALUES (?,?,?)";
	private static final String GET_BY_EVENT = "select * from event_counter where event_id = ?"; 

	private EventDao eventDao;
	
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	
	@Override
	protected EventCounter getBeanFromResultSet(ResultSet rs) throws SQLException {
		EventCounter eventCounter = new EventCounter();
		eventCounter.setId(rs.getInt("id"));
		eventCounter.setBookCount(rs.getInt("book_count"));
		eventCounter.setPriceCount(rs.getInt("price_count"));
		eventCounter.setByNameCount(rs.getInt("by_name_count"));
		eventCounter.setEvent(eventDao.getById(rs.getInt("event_id")));
		
		return eventCounter;
	}
	

	@Override
	public EventCounter getByEvent(Event event) {
		try {

			return jdbcTemplate.queryForObject(GET_BY_EVENT, new Object[] { event.getId() },

			new RowMapper<EventCounter>() {
				public EventCounter mapRow(ResultSet rs, int rowNum) throws SQLException {

					return getBeanFromResultSet(rs);

				}
			});

		} catch (Exception e) {

			// no rows
			return null;
		}
	}
	
	public EventCounter getByEventOrCreate(Event event) {
		
		EventCounter eventCounter = getByEvent(event);
		if(eventCounter == null) {
			eventCounter = new EventCounter();
			eventCounter.setEvent(event);
			create(eventCounter);
		}
		return eventCounter;
	}
	
	@Override
	public int incrementAndGetByNameCount(Event event) {
		EventCounter eventCounter = getByEventOrCreate(event);
		eventCounter.setByNameCount(eventCounter.getByNameCount() + 1);
		return eventCounter.getByNameCount();
	}

	@Override
	public int incrementAndGetPriceCount(Event event) {
		EventCounter eventCounter = getByEventOrCreate(event);
		eventCounter.setPriceCount(eventCounter.getPriceCount() + 1);
		return eventCounter.getPriceCount();
	}

	@Override
	public int incrementAndGetBookCount(Event event) {
		EventCounter eventCounter = getByEventOrCreate(event);
		eventCounter.setBookCount(eventCounter.getBookCount() + 1);
		return eventCounter.getBookCount();
	}

	@Override
	public void create(EventCounter eventCounter) {

		jdbcTemplate.update(
				INSERT_RECORD,
				eventCounter.getByNameCount(),
				eventCounter.getPriceCount(),
				eventCounter.getBookCount()
		);
		
	}

	public EventCounterDaoImpl() {
		super("event_counter");
	}

}
