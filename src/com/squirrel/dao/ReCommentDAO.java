package com.squirrel.dao;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.ReCommentDTO;

public class ReCommentDAO {

	public int insertComment(SqlSession session, ReCommentDTO dto) {
		int n = session.insert("ReCommentMapper.insertComment", dto);
		return n;
	}

}
