package com.squirrel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.GolfCcDTO;
import com.squirrel.dto.view.CcGolfScoreDTO;


public class GolfccDAO {

	public List<GolfCcDTO> selectGolfccName(SqlSession session, String loc_id) {
		List<GolfCcDTO> list = session.selectList("GolfccMapper.selectCCname", loc_id);
		return list;
	}

	public List<CcGolfScoreDTO> ccGolfScoreList(SqlSession session, HashMap<String, Object> searchVal) {
		// TODO Auto-generated method stub
		return session.selectList("GolfccMapper.ccGolfScoreList", searchVal);
	}

}
