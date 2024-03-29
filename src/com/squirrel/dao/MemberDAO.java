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

	public List<MemberDTO> adminMemberSelect(SqlSession session, HashMap<String, Object> map) {
			
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

	public void updateEmail(SqlSession session, int user_no) {
		session.update("MemberMapper.updateEmail", user_no);
		
	}

	public MemberDTO getUser(SqlSession session, int user_no) {
		MemberDTO dto = session.selectOne("MemberMapper.getUser", user_no);
		return dto;
	}


	public int totalRecord(SqlSession session) {
		int totalRecord = session.selectOne("MemberMapper.totalRecord");
		return totalRecord;
  }

	public MemberDTO getPhoneUser(SqlSession session, String phone_id) {
		MemberDTO dto = session.selectOne("MemberMapper.getPhoneUser", phone_id);
		return dto;

	}

	public int updatePW(SqlSession session, HashMap<String, String> map) {
		int confirm = session.update("MemberMapper.updatePW", map);
		return confirm;
	}

	public MemberDTO kakaoLogin(SqlSession session, String string) {
		// TODO Auto-generated method stub
		return session.selectOne("kakaoLogin",string);
	}

	public int kakaoMemberAdd(SqlSession session, MemberDTO dto) {
		// TODO Auto-generated method stub
		return session.insert("kakaoMemberAdd", dto);
	}

}
