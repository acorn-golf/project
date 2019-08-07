package com.squirrel.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.OrderListDAO;
import com.squirrel.dao.ProductDAO;
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

	public int addOrder(HashMap<String, Object> insertVal) {
		// TODO Auto-generated method stub
		SqlSession session = MySqlSessionFactory.getSession();
		int result = 0;
		OrderListDAO dao = new OrderListDAO();
		ProductDAO productDAO = new ProductDAO();
		try {
			
			result = productDAO.productDecrease(session,insertVal);
			if(result<=0)
				throw new Exception("최대인원 넘음");
			result = dao.addOrder(session,insertVal);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}
		finally {
			session.close();
		}
		return result;
	}

}
