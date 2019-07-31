package com.squirrel.controller.review;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.ReviewListDTO;
import com.squirrel.service.ReviewListService;

@WebServlet("/ReviewListServlet")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션처리 및 골프장자세히보기에서 파라미터를 받아야 한다
		// 골프장자세히보기에서 해당 골프장 cc_id를 받는다
		request.setCharacterEncoding("utf-8");
		
		String curPage = request.getParameter("curPage");
		if(curPage==null) {
			curPage="1";
		}
		
		String cc_id = "jj297 "; // 골프장 자세히 보기에서 받았다고 가정
		
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		String orderby = request.getParameter("orderby");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cc_id", cc_id);
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		map.put("orderby", orderby);
		
		System.out.println(map.get("cc_id")+"\t"+map.get("searchName")+"\t"+map.get("searchValue")+"\t"+map.get("orderby"));
		
		ReviewListService service = new ReviewListService();
		PageDTO<ReviewListDTO> pDTO = service.reviewList(map,Integer.parseInt(curPage));
		List<ReviewListDTO> list = pDTO.getList();
		
		int perPage = pDTO.getPerPage();
		int totalRecord = pDTO.getTotalRecord();
		int totalPage = totalRecord/perPage;
		if(totalRecord%perPage!=0) totalPage++;

		request.setAttribute("reviewList", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", Integer.parseInt(curPage));
		request.setAttribute("cc_id", cc_id);
		
		request.getRequestDispatcher("review/review.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
