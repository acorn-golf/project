package com.squirrel.controller.OrderList;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.view.IsOrderListDTO;
import com.squirrel.service.OrderListService;

@WebServlet("/IsOrderServlet")
public class IsOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pick_no = request.getParameter("pick_no");
		String p_id = request.getParameter("p_id");
		String g_amount = request.getParameter("g_amount");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("pick_no", pick_no);
		map.put("p_id", p_id);
		
		OrderListService service = new OrderListService();
		IsOrderListDTO dto = service.selectIsOrder(map);
				
		request.setAttribute("dto", dto);
		request.setAttribute("g_amount", g_amount);
		
		request.getRequestDispatcher("orderlist/orderlist.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
