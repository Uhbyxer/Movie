package com.epam.spring.movie.dao.stub;

import java.time.LocalDateTime;

import com.epam.spring.movie.bean.Assignment;
import com.epam.spring.movie.bean.Auditorium;
import com.epam.spring.movie.dao.AssignmentDao;


public class AssignmentDaoStub extends BaseDaoStub<Assignment> implements AssignmentDao {

	@Override
	public boolean isAssigned(Auditorium auditorium, LocalDateTime dateTime) {
		
		if(dateTime == null || auditorium == null) return true;
		
	 	return 	holder.entrySet()
	 			.stream()
	 			.filter(p -> dateTime.equals(p.getValue().getDateTime()))
	 			.filter(p -> auditorium.equals(p.getValue().getAuditorium()))
	 			.count() > 0;
	
	}
	
}
