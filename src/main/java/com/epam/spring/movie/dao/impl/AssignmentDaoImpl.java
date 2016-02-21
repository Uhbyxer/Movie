package com.epam.spring.movie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.movie.bean.Assignment;
import com.epam.spring.movie.bean.Auditorium;
import com.epam.spring.movie.dao.AssignmentDao;
import com.epam.spring.movie.dao.AuditoriumDao;
import com.epam.spring.movie.dao.EventDao;

public class AssignmentDaoImpl implements AssignmentDao {
	
	private static final String GET_ALL_RECORDS = "select * from assignment"; 
	private static final String GET_BY_ID = "select * from assignment where id = ?"; 
	private static final String INSERT_RECORD = "insert into assignment (event_id, auditorium_id, assignment_datetime) VALUES (?,?,?)";
	private static final String DELETE_RECORD = "delete from assignment where id = ?";
	private static final String GET_BY_AUDITORIUM_AND_TIME = "select count(*) from assignment where auditorium_id = ? and assignment_datetime = ?"; 
	
	private Assignment getAssignmentFromResultSet(ResultSet rs) throws SQLException {
		Assignment assignment = new Assignment();
		assignment.setId(rs.getInt("id"));
		assignment.setEvent(eventDao.getById(rs.getInt("event_id"))); 
		assignment.setAuditorium(auditoriumDao.getById(rs.getInt("auditorium_id")));
		
		if(rs.getObject("assignment_datetime") != null) {
			try {
				assignment.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(String.valueOf(rs.getString("assignment_datetime"))));
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
			
		return assignment;
	}	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	private EventDao eventDao;
	
	private AuditoriumDao auditoriumDao;
	
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	
	public void setAuditoriumDao(AuditoriumDao auditoriumDao) {
		this.auditoriumDao = auditoriumDao;
	}


	@Override
	public void create(Assignment assignment) {
		jdbcTemplate.update(
				INSERT_RECORD,
				assignment.getEvent().getId(),
				assignment.getAuditorium().getId(),
				java.util.Date.from(assignment.getDateTime().atZone(ZoneId.systemDefault()).toInstant())
		);
		
	}

	@Override
	public void remove(Assignment assignment) {
		jdbcTemplate.update(
				DELETE_RECORD,
				assignment.getId()
		);
		
	}

	@Override
	public List<Assignment> getAll() {
		
		return  jdbcTemplate.query(GET_ALL_RECORDS, new RowMapper<Assignment>() {
			
			public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {

				return getAssignmentFromResultSet(rs);
				
			}

		});
	}

	@Override
	public Assignment getById(Integer id) {
		try {

			return jdbcTemplate.queryForObject(GET_BY_ID, new Object[] { id },

			new RowMapper<Assignment>() {
				public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {

					return getAssignmentFromResultSet(rs);

				}
			});

		} catch (Exception e) {

			// no rows
			return null;
		}
	}

	@Override
	public boolean isAssigned(Auditorium auditorium, LocalDateTime dateTime) {

			return jdbcTemplate.queryForObject(
					GET_BY_AUDITORIUM_AND_TIME,Integer.class, 
					auditorium.getId(),
					java.util.Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant())) > 0;
					

	}

}
