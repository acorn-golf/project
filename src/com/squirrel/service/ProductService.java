package com.squirrel.service;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.config.MySqlSessionFactory;
import com.squirrel.dao.ProductDAO;
import com.squirrel.dto.ProductDTO;

public class ProductService {

	public void productInsert(ProductDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		ProductDAO dao = new ProductDAO();
		try {
			dao.productInsert(session,dto);
			session.commit();
		}finally {
			session.close();
		}
		
	}
	
	
	
	
	public ProductDTO productRetrieve(String p_id) {
		SqlSession session = MySqlSessionFactory.getSession();
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = null;
		try {
			dto = dao.productRetrieve(session,p_id);
			session.commit();
		}finally {
			session.close();
		}
		
		return dto;
		
	}

}
