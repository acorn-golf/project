package com.squirrel.controller.OrderList;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.ProductDTO;
import com.squirrel.service.OrderListService;
import com.squirrel.service.ProductService;

/**
 * Servlet implementation class AddOrderLast
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	
	OrderListService orderService = new OrderListService();
	ProductService productService = new ProductService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int user_no = (int)request.getSession().getAttribute("login");
		String p_id = request.getParameter("p_id");
		int o_amount = Integer.parseInt(request.getParameter("o_amount"));
		
		ProductDTO productDTO = productService.productRetrieve(p_id);
		
		HashMap<String, Object> insertVal = new HashMap<String, Object>();
		insertVal.put("user_no", user_no);
		insertVal.put("p_id", p_id);
		insertVal.put("o_amount", o_amount);
		insertVal.put("o_price", (int)(productDTO.getP_price()*o_amount));
		
		int resultchk = orderService.addOrder(insertVal);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
