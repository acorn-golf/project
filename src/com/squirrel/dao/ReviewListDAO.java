package com.squirrel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.CcScoreDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.ReviewListDTO;

public class ReviewListDAO {
	
	private int totalRecord(SqlSession session, HashMap<String, String> map) {
		return session.selectOne("ReviewViewMapper.totalRecord",map);
	}
	
	public PageDTO<ReviewListDTO> reviewList(SqlSession session, HashMap<String, String> map, int curPage) {
		PageDTO<ReviewListDTO> pDTO = new PageDTO<ReviewListDTO>();
		pDTO.setPerPage(10);
		int perPage = pDTO.getPerPage();
		int offset = (curPage)*perPage;
		int totalRecord = totalRecord(session,map);
		List<ReviewListDTO> list = session.selectList("ReviewViewMapper.reviewList", map,new RowBounds(offset, perPage));
		
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

	public ReviewListDTO selectNickname(SqlSession session, int score_no) {
		ReviewListDTO rdto = session.selectOne("ReviewViewMapper.selectNick", score_no);
		return rdto;
	}

	public void updateReview(SqlSession session, CcScoreDTO cdto) {
		session.update("ReviewMapper.updateReview", cdto);
		
	}

	public void deleteReview(SqlSession session, int score_no) {
		session.delete("ReviewMapper.deleteReview", score_no);
		
	}
	
}
