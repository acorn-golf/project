package com.squirrel.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.MemberDAO;
import com.squirrel.dto.MemberDTO;

public class MemberService {
	
	MemberDAO dao;

	public MemberService() {

		dao = new MemberDAO();
	}

	public int MemberAdd(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int confirm = 0;
		try {
			confirm = dao.MemberAdd(session,dto);
			if(confirm != 0) {
				session.commit();
			}else {	
				session.rollback();				
			}
		}finally {
			session.close();
		}		
		return confirm;
	}

	public MemberDTO login(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = dao.login(session,map);
		}finally {
			session.close();
		}		
		return dto;
	}

	public MemberDTO myPage(int user_no) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = dao.myPage(session,user_no);
		}finally {
			session.close();
		}
		return dto;
	}

}
