package com.squirrel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.GolfCcDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.CcGolfScoreDTO;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class GolfccDAO {

	public List<GolfCcDTO> selectGolfccName(SqlSession session, String loc_id) {
		List<GolfCcDTO> list = session.selectList("GolfccMapper.selectCCname", loc_id);
		return list;
	}

	public List<CcGolfScoreDTO> ccGolfScoreList(SqlSession session, HashMap<String, Object> searchVal) {
		// TODO Auto-generated method stub
		return session.selectList("GolfccMapper.ccGolfScoreList", searchVal);
	}

	public PageDTO<CcGolfScoreDTO> ccGolfScoreList(SqlSession session, HashMap<String, Object> searchVal,
			PageDTO<CcGolfScoreDTO> pageDto) {
		// TODO Auto-generated method stub
		RowBounds bounds = new RowBounds(pageDto.getCurPage()*pageDto.getPerPage(), pageDto.getPerPage());
		pageDto.setList(session.selectList("GolfccMapper.ccGolfScoreList",searchVal,bounds));
		System.out.println("신난다  "+pageDto.getList().size());
		return pageDto;
	}
	
	public int ccGolfScoreListCount(SqlSession session, HashMap<String, Object> searchVal) {
		return session.selectOne("GolfccMapper.ccGolfScoreListCount",searchVal);
	}

	public CcGolfScoreDTO getGolfccScoreOne(SqlSession session, String cc_id) {
		// TODO Auto-generated method stub
		return session.selectOne("GolfccMapper.getGolfccScoreOne",cc_id);
	}

}
