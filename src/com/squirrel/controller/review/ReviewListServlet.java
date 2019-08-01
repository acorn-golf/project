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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션처리 및 골프장자세히보기에서 파라미터를 받아야 한다
		// 골프장자세히보기에서 해당 골프장 cc_id를 받는다
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		boolean ReSearchChk = false;
		int curPage;
		{
			String curPageStr = request.getParameter("curPage");
			if (curPageStr == null) {
				curPage = 0;
				ReSearchChk = true;
			}else
				curPage=Integer.parseInt(curPageStr)-1;
		}
		String cc_id = "jj297 "; // 골프장 자세히 보기에서 받았다고 가정

		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		String orderby = request.getParameter("orderby");

		if (orderby != null) { // 정렬값 재세팅
			if (!orderby.equals((String) session.getAttribute("orderby"))) {
				session.setAttribute("orderby", orderby);
			}
		}

		if (ReSearchChk) {// 검색값 재세팅
			if (searchName == null) {
				// 검색값을 아무것도 입력하지 않은 경우 전부검색
				session.removeAttribute("searchName");
				session.removeAttribute("searchValue");
			} else {
				// 검색값 입력 시
				session.setAttribute("searchName", searchName);
				session.setAttribute("searchValue", searchValue);
			}
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cc_id", cc_id);
		map.put("searchName", (String) session.getAttribute("searchName"));
		map.put("searchValue", (String) session.getAttribute("searchValue"));
		map.put("orderby", (String) session.getAttribute("orderby"));

		ReviewListService service = new ReviewListService();
		PageDTO<ReviewListDTO> pDTO = service.reviewList(map, curPage);
		List<ReviewListDTO> list = pDTO.getList();

		int perPage = pDTO.getPerPage();
		int totalRecord = pDTO.getTotalRecord();
		int totalPage = totalRecord / perPage;
		System.out.println("totalRecord: "+totalRecord);
		System.out.println("perPage: "+perPage);
		System.out.println("totalPage: "+totalPage);
		if (totalRecord % (float)perPage != 0) {
			totalPage++;
		}
		System.out.println("!_#!)(#! totalPage: "+totalPage);
		int showBlock = 5; // 보여줄 페이지 1,2,3,4,5 // 6,7,8,9,10
		int minBlock = (curPage / (showBlock)) * showBlock;
		int maxBlock = 0;
		System.out.println("토탈"+totalPage+"  min:"+minBlock+"  showBlock:"+showBlock);
		if (curPage == totalPage || totalPage < minBlock+showBlock) {
			maxBlock = totalPage;
			System.out.println("집");
		} else if (curPage < totalPage) {
			maxBlock = minBlock + showBlock;
			System.out.println("가고싶다");
		}
		System.out.println(maxBlock);
		request.setAttribute("minBlock", minBlock);
		request.setAttribute("maxBlock", maxBlock);

		request.setAttribute("reviewList", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", curPage);
		request.setAttribute("cc_id", cc_id);

		request.getRequestDispatcher("review/review.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
