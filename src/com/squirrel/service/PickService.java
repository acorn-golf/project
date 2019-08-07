package com.squirrel.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.PickDAO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.PickListDTO;
import com.squirrel.dto.view.PickListviewDTO;

public class PickService {

	public void insertPick(PickListDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		PickDAO dao = new PickDAO();
		try {
			dao.insertPick(session,dto);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	public PageDTO<PickListviewDTO> selectPickList(int user_no, int curPage) {
		SqlSession session = MySqlSessionFactory.getSession();
		PageDTO<PickListviewDTO> pdto = null;
		PickDAO dao = new PickDAO();
		try {
			pdto = dao.selectPickList(session,user_no,curPage);
		}finally {
			session.close();
		}
		
		return pdto;
	}

	public void deletePick(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		PickDAO dao = new PickDAO();
		try {
			dao.deletePick(session,list);
			session.commit();
		}finally {
			session.close();
		}
	}

}
