package com.squirrel.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.OrderListDAO;
import com.squirrel.dto.view.IsOrderListDTO;

public class OrderListService {

	public IsOrderListDTO selectIsOrder(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		IsOrderListDTO dto = null;
		OrderListDAO dao = new OrderListDAO();
		try {
			dto = dao.selectIsOrder(session,map);
		}finally {
			session.close();
		}
		return dto;
	}

}
