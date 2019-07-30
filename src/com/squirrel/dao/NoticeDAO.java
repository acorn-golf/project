package com.squirrel.dao;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.NoticeListDTO;
import com.squirrel.dto.ProductDTO;



public class NoticeDAO {

	
		public void NoticeInsert(SqlSession session, NoticeListDTO ndto) {
			System.out.println("note_content".toString());
			System.out.println("note_no".toString());
			System.out.println("note_title".toString());
			System.out.println("user_no".toString());
			System.out.println("notedate".toString());
			System.out.println("note_division".toString());
			System.out.println("note_file".toString());
			System.out.println("note_vcount".toString());
			session.insert("NoticeMapper.NoticeInsert", ndto);
	}
}
