package com.squirrel.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.view.IsOrderListDTO;

public class OrderListDAO {

	public IsOrderListDTO selectIsOrder(SqlSession session, HashMap<String, String> map) {
		IsOrderListDTO dto = session.selectOne("OrderListMapper.selectIsOrder", map);
		return dto;
	}

}
