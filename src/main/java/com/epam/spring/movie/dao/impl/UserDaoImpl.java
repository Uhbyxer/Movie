package com.epam.spring.movie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.dao.UserDao;

public class UserDaoImpl implements UserDao {
	
	private static final String GET_ALL_RECORDS = "select * from user"; 
	private static final String GET_BY_EMAIL = "select * from user where lower(email) = lower(?)"; 
	private static final String GET_BY_ID = "select * from user where id = ?"; 
	private static final String GET_BY_NAME = "select * from user where lower(name) = lower(?)";
	private static final String INSERT_RECORD = "insert into user (name, email, birth) VALUES (?,?,?)";
	private static final String DELETE_RECORD = "delete from user where id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private User getUserFromResultSet(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		
		if(rs.getObject("birth") != null) {
			try {
				user.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(rs.getString("birth"))));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}

	@Override
	public void create(User user) {
		jdbcTemplate.update(
				INSERT_RECORD,
				user.getName(),
				user.getEmail(),
				
				user.getBirth() == null ? null : 
					java.util.Date.from(user.getBirth().atStartOfDay(ZoneId.systemDefault()).toInstant())
		);
	}

	@Override
	public void remove(User user) {

			jdbcTemplate.update(
					DELETE_RECORD,
					user.getId()
			);

	}

	@Override
	public List<User> getAll() {
		return  jdbcTemplate.query(GET_ALL_RECORDS, new RowMapper<User>() {
			
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {

				return getUserFromResultSet(rs);
				
			}

		});
	}

	@Override
	public User getById(Integer id) {
		try {

			return jdbcTemplate.queryForObject(GET_BY_ID, new Object[] { id },

			new RowMapper<User>() {
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {

					return getUserFromResultSet(rs);

				}
			});

		} catch (Exception e) {

			// no rows
			return null;
		}

	}

	@Override
	public List<User> getListByName(String name) {
		return  jdbcTemplate.query(GET_BY_NAME, new Object[] { name }, new RowMapper<User>() {
			
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {

				return getUserFromResultSet(rs);
				
			}

		});
	}

	@Override
	public User getUserByEmail(String email) {

		try {

			return jdbcTemplate.queryForObject(GET_BY_EMAIL, new Object[] { email },

			new RowMapper<User>() {
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {

					return getUserFromResultSet(rs);

				}
			});

		} catch (Exception e) {
			
			//no rows
			return null;
		}
	}

}
