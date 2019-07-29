package com.squirrel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.LocationDTO;

public class LocationDAO {

	public List<LocationDTO> locationList(SqlSession session) {
		List<LocationDTO> list = session.selectList("LocationMapper.LocationList");
		return list;
	}

}
