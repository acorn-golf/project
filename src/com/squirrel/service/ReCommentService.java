package com.squirrel.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.ReCommentDAO;
import com.squirrel.dto.ReCommentDTO;
import com.squirrel.dto.view.RecommentViewDTO;

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

	public List<RecommentViewDTO> selectRecomment(int score_no) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<RecommentViewDTO> list = null;
		ReCommentDAO dao = new ReCommentDAO();
		try {
			list = dao.selectRecomment(session,score_no);
		}finally {
			session.close();
		}
		return list;
	}

	public int updateComment(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		ReCommentDAO dao = new ReCommentDAO(); 
		try {
			n = dao.updateComment(session,map);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

	public int deleteComment(String re_no) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		ReCommentDAO dao = new ReCommentDAO(); 
		try {
			n = dao.deleteComment(session,re_no);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

}
