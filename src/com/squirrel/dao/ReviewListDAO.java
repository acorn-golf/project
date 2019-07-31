package com.squirrel.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.CcScoreDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.ReviewListDTO;

public class ReviewListDAO {
	
	private int totalRecord(SqlSession session) {
		return session.selectOne("ReviewViewMapper.totalRecord");
	}
	
	public PageDTO<ReviewListDTO> reviewList(SqlSession session, String cc_id, int curPage) {
		PageDTO<ReviewListDTO> pDTO = new PageDTO<ReviewListDTO>();
		pDTO.setPerPage(5);
		int perPage = pDTO.getPerPage();
		int offset = (curPage-1)*perPage;
		int totalRecord = totalRecord(session);
		List<ReviewListDTO> list = session.selectList("ReviewViewMapper.reviewList", cc_id,new RowBounds(offset, perPage));
		
		pDTO.setList(list);
		pDTO.setCurPage(curPage);
		pDTO.setTotalRecord(totalRecord);
		return pDTO;
	}

	public void insertReview(SqlSession session, CcScoreDTO dto) {
		session.insert("ReviewMapper.insertReview", dto);
		
	}

	public CcScoreDTO selectDetail(SqlSession session, int score_no) {
		rv_vcount(session, score_no);
		CcScoreDTO dto = session.selectOne("ReviewMapper.selectDetail", score_no);
		return dto;
	}
	
	private void rv_vcount(SqlSession session, int score_no) {
		session.update("ReviewMapper.rv_vcount", score_no);
	}
	
}
