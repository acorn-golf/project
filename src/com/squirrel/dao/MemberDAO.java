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

	public List<MemberDTO> adminMemberSelect(SqlSession session, HashMap<String, String> map) {
			
		List<MemberDTO> list = session.selectList("MemberMapper.adminMemberSelect",map);
	
		return list;
	}

	public int adminModified(SqlSession session, MemberDTO userdto) {
		
		int confirm = session.update("MemberMapper.adminModified",userdto);
		
		return confirm;
	}

	public MemberDTO getMemberInfo(SqlSession session, int user_no) {
		// TODO Auto-generated method stub
		MemberDTO dto = session.selectOne("MemberMapper.getMemberInfo", user_no);
		return dto;
	}

}
