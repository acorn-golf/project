package com.squirrel.dao;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.MemberDTO;

public class MemberDAO {

	public int MemberAdd(SqlSession session, MemberDTO dto) {
		
		int confirm = session.insert("MemberMapper.MemberAdd",dto);
		
		return confirm;
	}

}
