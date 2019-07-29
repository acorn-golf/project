package com.squirrel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.GolfCcDTO;


public class GolfccDAO {

	public List<GolfCcDTO> selectGolfccName(SqlSession session, String loc_id) {
		List<GolfCcDTO> list = session.selectList("GolfccMapper.selectCCname", loc_id);
		return list;
	}

}
