package com.squirrel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.ReCommentDTO;
import com.squirrel.dto.view.RecommentViewDTO;

public class ReCommentDAO {

	public int insertComment(SqlSession session, ReCommentDTO dto) {
		int n = session.insert("ReCommentMapper.insertComment", dto);
		return n;
	}

	public List<RecommentViewDTO> selectRecomment(SqlSession session, int score_no) {
		List<RecommentViewDTO> list = session.selectList("ReCommentMapper.selectRecomment", score_no);
		return list;
	}

	public int updateComment(SqlSession session, HashMap<String, String> map) {
		int n = session.update("ReCommentMapper.updateComment", map);
		return n;
	}

	public int deleteComment(SqlSession session, String re_no) {
		int n = session.update("ReCommentMapper.deleteComment", re_no);
		return n;
	}

}
