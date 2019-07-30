package com.squirrel.service;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.NoticeDAO;
import com.squirrel.dao.ProductDAO;
import com.squirrel.dto.NoticeListDTO;
import com.squirrel.dto.ProductDTO;

public class NoticeService {

	public void NoticeInsert(NoticeListDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		NoticeDAO dao = new NoticeDAO();
		try {
			dao.NoticeInsert(session,dto);
			session.commit();
		}finally {
			session.close();
		}
		
	}

}
