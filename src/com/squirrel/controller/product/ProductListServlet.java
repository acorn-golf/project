package com.squirrel.controller.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.ProductListDTO;
import com.squirrel.service.ProductService;

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		boolean ReSearchChk = false;
		int curPage; // 현재페이지
		{
			String curPageStr = request.getParameter("curPage");
			if (curPageStr == null) {
				curPage = 0;
				ReSearchChk = true;
			}else
				curPage=Integer.parseInt(curPageStr)-1;
		}
		
		String loc_id = request.getParameter("loc_id");
		String productDivision = request.getParameter("productDivision"); // 검색구분
		String emergency = request.getParameter("emergency"); // 긴급상품
		String productValue = request.getParameter("productValue"); // 검색값
		String productOrderby = request.getParameter("productOrderby"); // 정렬
		System.out.println(emergency);
		if (productOrderby != null) { // 정렬값 재세팅
			if (!productOrderby.equals((String) session.getAttribute("productOrderby"))) {
				session.setAttribute("productOrderby", productOrderby);
			}
		}
		
		if(emergency != null) { // 긴급상품 재세팅
			session.setAttribute("emergency", emergency);
		}else {
			session.removeAttribute("emergency");
		}
		
		if (ReSearchChk) {// 검색값 재세팅
			if (productDivision == null) {
				// 검색값을 아무것도 입력하지 않은 경우 전부검색
				session.removeAttribute("productDivision");
				session.removeAttribute("productValue");
			} else {
				// 검색값 입력 시
				session.setAttribute("productDivision", productDivision);
				session.setAttribute("productValue", productValue);
			}
			if(loc_id==null||loc_id.equals("all")) { // 지역별 재세팅
				session.removeAttribute("loc_id");
			}else {
				session.setAttribute("loc_id", loc_id);
			}
		}
		System.out.println(session.getAttribute("emergency"));
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("loc_id", (String)session.getAttribute("loc_id"));
		map.put("emergency", (String)session.getAttribute("emergency"));
		map.put("productDivision", (String)session.getAttribute("productDivision"));
		map.put("productValue", (String)session.getAttribute("productValue"));
		map.put("productOrderby", (String)session.getAttribute("productOrderby"));
		
		ProductService service = new ProductService();
		PageDTO<ProductListDTO> pDTO = service.selectProduct(map,curPage);
		List<ProductListDTO> list = pDTO.getList();
		
		int perPage = pDTO.getPerPage();
		int totalRecord = pDTO.getTotalRecord();
		int totalPage = totalRecord / perPage;

		if (totalRecord % (float)perPage != 0) {
			totalPage++;
		}

		int showBlock = 5; // 보여줄 페이지 1,2,3,4,5 // 6,7,8,9,10
		int minBlock = (curPage / (showBlock)) * showBlock;
		int maxBlock = 0;
		if (curPage == totalPage || totalPage < minBlock+showBlock) {
			maxBlock = totalPage;
		} else if (curPage < totalPage) {
			maxBlock = minBlock + showBlock;
		}
		int perBlock = 0;//totalPage/showBlock;
		if(totalPage%showBlock==0) {
			perBlock = (totalPage/showBlock)-1;
		}else {
			perBlock = totalPage/showBlock;
		}
		
		
		request.setAttribute("perBlock", perBlock);
		request.setAttribute("minBlock", minBlock);
		request.setAttribute("maxBlock", maxBlock);
		request.setAttribute("showBlock", showBlock);
		request.setAttribute("productList", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", curPage);
		
		request.getRequestDispatcher("product/productList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
