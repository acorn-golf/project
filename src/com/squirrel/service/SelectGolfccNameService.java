package com.squirrel.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.SelectGolfccNameDAO;
import com.squirrel.dto.GolfCcDTO;

public class SelectGolfccNameService {

	public List<GolfCcDTO> selectGolfccName(String loc_id) {
		List<GolfCcDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		SelectGolfccNameDAO dao = new SelectGolfccNameDAO();
		try {
			list = dao.selectGolfccName(session,loc_id);
		}finally {
			session.close();
		}
		return list;
	}

}
