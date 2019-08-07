package com.squirrel.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.view.IsOrderListDTO;

public class OrderListDAO {

	public IsOrderListDTO selectIsOrder(SqlSession session, HashMap<String, String> map) {
		IsOrderListDTO dto = session.selectOne("OrderListMapper.selectIsOrder", map);
		return dto;
	}

	public int addOrder(SqlSession session, HashMap<String, Object> insertVal) {
		// TODO Auto-generated method stub
		return session.insert("OrderListMapper.addOrder", insertVal);
	}

}
