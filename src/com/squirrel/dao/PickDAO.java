package com.squirrel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.PageDTO;
import com.squirrel.dto.PickListDTO;
import com.squirrel.dto.view.PickListviewDTO;
import com.squirrel.dto.view.ProductListDTO;

public class PickDAO {

	public void insertPick(SqlSession session, PickListDTO dto) {
		session.insert("PickListMapper.insertPick", dto);
		
	}

	private int totalRecord(SqlSession session, int user_no) {
		return session.selectOne("PickListMapper.totalRecord",user_no);
	}
	
	public PageDTO<PickListviewDTO> selectPickList(SqlSession session, int user_no, int curPage) {
		PageDTO<PickListviewDTO> pdto = new PageDTO<PickListviewDTO>();
		pdto.setPerPage(10);
		int perPage = pdto.getPerPage();
		int offset = (curPage)*perPage;
		int totalRecord = totalRecord(session,user_no);
		List<PickListviewDTO> list = session.selectList("PickListMapper.selectPickList", user_no, new RowBounds(offset, perPage));
		
		pdto.setList(list);
		pdto.setCurPage(curPage);
		pdto.setTotalRecord(totalRecord);
		
		return pdto;
	}

	public void deletePick(SqlSession session, List<String> list) {
		session.delete("PickListMapper.deletePick", list);
		
	}

}
