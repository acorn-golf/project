package com.squirrel.service;

import java.util.HashMap;
import java.util.List;

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

	public MemberDTO myPage(String nickname) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = dao.myPage(session,nickname);
		}finally {
			session.close();
		}
		return dto;
	}

	public int myPageUpdate(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int confirm = 0;
		try {
			confirm = dao.myPageUpdate(session,dto);
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

	public int multiCheck(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		int confirm;
		try {
			confirm = dao.multiCheck(session,map);
		}finally {
			session.close();
		}
		return confirm;
	}

	public List<MemberDTO> adminMemberSelect(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<MemberDTO> list = null;
		try {
			list = dao.adminMemberSelect(session,map);
		}finally {
			session.close();
		}		
		return list;
	}

	public int adminModified(MemberDTO userdto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int confirm = 0;
		try {
			confirm = dao.adminModified(session,userdto);
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

	public MemberDTO getMemberInfo(int user_no) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = dao.getMemberInfo(session,user_no);
		}finally {
			session.close();
		}		
		return dto;
	}

	public void updateEmail(int user_no) {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			dao.updateEmail(session,user_no);
			session.commit();
		}finally {
			session.close();
		}
	}

	public MemberDTO getUser(int user_no) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto = null;
		try {
			dto = dao.getUser(session,user_no);
		}finally {
			session.close();
		}
		return dto;
	}

	public int totalRecord() {
		SqlSession session = MySqlSessionFactory.getSession();
		int totalRecord = 0;
		try {
			totalRecord = dao.totalRecord(session);
		}finally {
			session.close();
		}
		return totalRecord;
	}
	
	
	
}
