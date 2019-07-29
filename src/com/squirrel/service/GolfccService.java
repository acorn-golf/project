package com.squirrel.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.GolfccDAO;
import com.squirrel.dto.GolfCcDTO;

public class GolfccService {

	public List<GolfCcDTO> selectGolfccName(String loc_id) {
		List<GolfCcDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		GolfccDAO dao = new GolfccDAO();
		try {
			list = dao.selectGolfccName(session,loc_id);
		}finally {
			session.close();
		}
		return list;
	}

}
