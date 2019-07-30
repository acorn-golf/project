package com.squirrel.dao;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.NoticeListDTO;
import com.squirrel.dto.ProductDTO;



public class NoticeDAO {

	
		public void NoticeInsert(SqlSession session, NoticeListDTO ndto) {
			session.insert("NoticeMapper.NoticeInsert", ndto);
	}
}
