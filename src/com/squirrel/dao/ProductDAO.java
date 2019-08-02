package com.squirrel.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.squirrel.dto.PageDTO;
import com.squirrel.dto.ProductDTO;
import com.squirrel.dto.view.ProductListDTO;

public class ProductDAO {

	public void productInsert(SqlSession session, ProductDTO dto) {
		session.insert("ProductMapper.productInsert", dto);
	}
	
	private int totalRecord(SqlSession session, HashMap<String, String> map) {
		return session.selectOne("ProductMapper.totalRecord",map);
	}
	
	public PageDTO<ProductListDTO> selectProduct(SqlSession session, HashMap<String, String> map, int curPage) {
		PageDTO<ProductListDTO> pdto = new PageDTO<ProductListDTO>();
		pdto.setPerPage(10);
		int perPage = pdto.getPerPage();
		int offset = (curPage)*perPage;
		int totalRecord = totalRecord(session,map);
		List<ProductListDTO> list = session.selectList("ProductMapper.selectProduct", map, new RowBounds(offset, perPage));
		
		pdto.setList(list);
		pdto.setCurPage(curPage);
		pdto.setTotalRecord(totalRecord);
		
		return pdto;
	}
	
	

}
