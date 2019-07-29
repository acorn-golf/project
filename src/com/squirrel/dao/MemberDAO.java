package com.squirrel.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.MemberDTO;

public class MemberDAO {

	public int MemberAdd(SqlSession session, MemberDTO dto) {
		
		int confirm = session.insert("MemberMapper.MemberAdd",dto);
		
		return confirm;
	}

	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		
		MemberDTO dto = session.selectOne("MemberMapper.login", map);
		return dto;
	}

	public MemberDTO myPage(SqlSession session, int user_no) {
		
		MemberDTO dto = session.selectOne("MemberMapper.myPage", user_no);
		return dto;
	}

}
