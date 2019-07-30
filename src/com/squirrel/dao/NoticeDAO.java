package com.squirrel.dao;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.NoticeListDTO;
import com.squirrel.dto.ProductDTO;



public class NoticeDAO {

	
		public void NoticeInsert(SqlSession session, NoticeListDTO dto) {
			session.insert("NoticeMapper.NoticeInsert", dto);
	}
}
