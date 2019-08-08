package com.squirrel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.IsOrderListDTO;
import com.squirrel.dto.view.OrderInfoDTO;

public class OrderListDAO {

	public IsOrderListDTO selectIsOrder(SqlSession session, HashMap<String, String> map) {
		IsOrderListDTO dto = session.selectOne("OrderListMapper.selectIsOrder", map);
		return dto;
	}

	public int addOrder(SqlSession session, HashMap<String, Object> insertVal) {
		// TODO Auto-generated method stub
		return session.insert("OrderListMapper.addOrder", insertVal);
	}

	private int totalRecord(SqlSession session, int user_no) {
		return session.selectOne("OrderListMapper.totalRecord",user_no);
	}
	
	public PageDTO<OrderInfoDTO> selectOrderList(SqlSession session, int user_no, int curPage) {
		PageDTO<OrderInfoDTO> pdto = new PageDTO<OrderInfoDTO>();
		pdto.setPerPage(10);
		int perPage = pdto.getPerPage();
		int offset = (curPage)*perPage;
		int totalRecord = totalRecord(session,user_no);
		List<OrderInfoDTO> list = session.selectList("OrderListMapper.selectOrderList", user_no, new RowBounds(offset, perPage));
		
		pdto.setList(list);
		pdto.setCurPage(curPage);
		pdto.setTotalRecord(totalRecord);
		
		return pdto;
	}

}
