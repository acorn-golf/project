package com.squirrel.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.LocationDAO;
import com.squirrel.dto.LocationDTO;

public class LocationService {

	public List<LocationDTO> locationList() {
		SqlSession session = MySqlSessionFactory.getSession();
		List<LocationDTO> list = null;
		LocationDAO dao = new LocationDAO(); 
		try {
			list = dao.locationList(session);
		}finally{
			session.close();
		}
		return list;
	}
	
	
}
