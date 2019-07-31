package com.squirrel.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.ReviewListDAO;
import com.squirrel.dto.CcScoreDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.ReviewListDTO;

public class ReviewListService {

	public PageDTO<ReviewListDTO> reviewList(String cc_id, int curPage) {
		PageDTO<ReviewListDTO> pDTO = null;
		SqlSession session = MySqlSessionFactory.getSession();
		ReviewListDAO dao = new ReviewListDAO();
		try {
			pDTO = dao.reviewList(session,cc_id,curPage);
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

}
