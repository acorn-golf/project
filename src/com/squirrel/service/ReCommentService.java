package com.squirrel.service;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.ReCommentDAO;
import com.squirrel.dto.ReCommentDTO;

public class ReCommentService {

	public int insertComment(ReCommentDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		ReCommentDAO dao = new ReCommentDAO(); 
		try {
			n = dao.insertComment(session,dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

}
