package com.squirrel.dao;

import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.ProductDTO;

public class ProductDAO {

	public void productInsert(SqlSession session, ProductDTO dto) {
		session.insert("ProductMapper.productInsert", dto);
	}

}
