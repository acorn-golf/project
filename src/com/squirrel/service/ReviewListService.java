package com.squirrel.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.ReviewListDAO;
import com.squirrel.dto.CcScoreDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.ReviewListDTO;

public class ReviewListService {

	public PageDTO<ReviewListDTO> reviewList(HashMap<String, String> map, int curPage) {
		PageDTO<ReviewListDTO> pDTO = null;
		SqlSession session = MySqlSessionFactory.getSession();
		ReviewListDAO dao = new ReviewListDAO();
		try {
			pDTO = dao.reviewList(session,map,curPage);
		}finally {
			session.close();
		}
		return pDTO;
	}

	public void insertReview(CcScoreDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		ReviewListDAO dao = new ReviewListDAO();
		try {
			dao.insertReview(session, dto);
			session.commit();
		}finally {
			session.close();
		}
	}

	public CcScoreDTO selectDetail(int score_no) {
		SqlSession session = MySqlSessionFactory.getSession();
		CcScoreDTO dto = null;
		ReviewListDAO dao = new ReviewListDAO();
		try {
			dto = dao.selectDetail(session,score_no);
			session.commit();
		}finally {
			session.close();
		}
		return dto;
	}

	public ReviewListDTO selectNickname(int score_no) {
		SqlSession session = MySqlSessionFactory.getSession();
		ReviewListDTO rdto = null;
		ReviewListDAO dao = new ReviewListDAO();
		try {
			rdto = dao.selectNickname(session,score_no);
		}finally {
			session.close();
		}
		return rdto;
	}

	public void updateReview(CcScoreDTO cdto) {
		SqlSession session = MySqlSessionFactory.getSession();
		ReviewListDAO dao = new ReviewListDAO();
		try {
			dao.updateReview(session,cdto);
			session.commit();
		}finally {
			session.close();
		}
	}

	public void deleteReview(int score_no) {
		SqlSession session = MySqlSessionFactory.getSession();
		ReviewListDAO dao = new ReviewListDAO();
		try {
			dao.deleteReview(session, score_no);
			session.commit();
		}finally {
			session.close();
		}
	}

}
