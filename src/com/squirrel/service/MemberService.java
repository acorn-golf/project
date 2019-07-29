package com.squirrel.service;

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
			if(confirm==0) { //0일 경우 등록안됨입니다.   숫자는 등록이 성공된 갯수
				session.commit();
			}else {	
				session.rollback();				
			}
		}finally {
			session.close();
		}		
		return confirm;
	}

}
