package com.squirrel.controller.OrderList;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.OrderInfoDTO;
import com.squirrel.service.OrderListService;

@WebServlet("/OrderedServlet")
public class OrderedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = (MemberDTO)request.getSession().getAttribute("login");
		int user_no = dto.getUser_no();
		
		int curPage; // 현재페이지
		{
			String curPageStr = request.getParameter("curPage");
			if (curPageStr == null) {
				curPage = 0;
			}else
				curPage=Integer.parseInt(curPageStr)-1;
		}
		
		OrderListService service = new OrderListService();
		PageDTO<OrderInfoDTO> pdto = service.selectOrderList(user_no,curPage);
		List<OrderInfoDTO> list = pdto.getList();
		
		int perPage = pdto.getPerPage();
		int totalRecord = pdto.getTotalRecord();
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
		request.setAttribute("orderList", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", curPage);
		
		request.getRequestDispatcher("orderlist/orderlistview.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
