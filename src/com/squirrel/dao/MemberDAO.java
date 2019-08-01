package com.squirrel.dao;

import java.util.HashMap;
import java.util.List;

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

	public MemberDTO myPage(SqlSession session, String nickname) {
		
		MemberDTO dto = session.selectOne("MemberMapper.myPage", nickname);
		return dto;
	}

	public int myPageUpdate(SqlSession session, MemberDTO dto) {
		
		int confirm = session.update("MemberMapper.myPageUpdate",dto);
		
		return confirm;
	}

	public int multiCheck(SqlSession session, HashMap<String, String> map) {

		int confirm = session.selectOne("MemberMapper.multiCheck",map);
		
		return confirm;
	}

	public List<MemberDTO> memberSelect(SqlSession session) {
		
		List<MemberDTO> list = session.selectList("MemberMapper.memberSelect");
		
		return list;
	}

}
