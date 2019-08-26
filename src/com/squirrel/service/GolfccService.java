package com.squirrel.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.GolfccDAO;
import com.squirrel.dto.GolfCcDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.CcGolfScoreDTO;

public class GolfccService {
	
	GolfccDAO dao;

	public GolfccService() {
		
		dao = new GolfccDAO();
	}

	public List<GolfCcDTO> selectGolfccName(String loc_id) {
		List<GolfCcDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			list = dao.selectGolfccName(session,loc_id);
		}finally {
			session.close();
		}
		return list;
	}
	
	public List<CcGolfScoreDTO> ccGolfScoreList(HashMap<String, Object> searchVal ) {
		List<CcGolfScoreDTO> result = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			result = new GolfccDAO().ccGolfScoreList(session,searchVal);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		
		return result;
	}

	public PageDTO<CcGolfScoreDTO> ccGolfScoreList(HashMap<String, Object> searchVal, PageDTO<CcGolfScoreDTO> pageDto) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			pageDto.setTotalRecord(dao.ccGolfScoreListCount(session, searchVal));
			pageDto = dao.ccGolfScoreList(session,searchVal,pageDto);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return pageDto;
	}

	public CcGolfScoreDTO getGolfccScoreOne(String cc_id) {
		// TODO Auto-generated method stub
		CcGolfScoreDTO result = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			result = new GolfccDAO().getGolfccScoreOne(session,cc_id);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		
		return result;
	}

	public void LikeGolfccRemove(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	public void LikeGolfccAdd(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	public List<GolfCcDTO> adminGolfSelect(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GolfCcDTO> list = null;
		try {
			list = dao.adminGolfSelect(session,map);
		}finally {
			session.close();
		}		
		return list;
	}

	public int totalRecord() {
		SqlSession session = MySqlSessionFactory.getSession();
		int totalRecord = 0;
		try {
			totalRecord = dao.totalRecord(session);
		}finally {
			session.close();
		}
		return totalRecord;
	}

}
