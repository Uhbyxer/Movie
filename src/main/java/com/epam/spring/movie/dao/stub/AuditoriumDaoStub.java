package com.epam.spring.movie.dao.stub;

import java.util.List;
import com.epam.spring.movie.bean.Auditorium;
import com.epam.spring.movie.dao.AuditoriumDao;


public class AuditoriumDaoStub extends BaseDaoStub<Auditorium> implements AuditoriumDao {
	
	@Override
	public List<Auditorium> getAuditoriumByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
