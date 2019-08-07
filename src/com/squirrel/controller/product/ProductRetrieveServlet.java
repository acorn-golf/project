package com.squirrel.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.ProductDTO;
import com.squirrel.dto.view.CcGolfScoreDTO;
import com.squirrel.service.GolfccService;
import com.squirrel.service.MemberService;
import com.squirrel.service.ProductService;

/**
 * Servlet implementation class ProductRetrieveServlet
 */
@WebServlet("/ProductRetrieveServlet")
public class ProductRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		productRetrieve(request, response);
		
		
		request.getRequestDispatcher("product/productRetrieve.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void productRetrieve(HttpServletRequest request, HttpServletResponse response) {
		String p_id = request.getParameter("p_id");	
		
		
		ProductDTO productDTO = null;
		CcGolfScoreDTO golfScoreDTO = null;
		MemberDTO memberDTO = null;
		ProductService pservice = new ProductService();
		GolfccService golfccService = new GolfccService();
		MemberService memberService = new MemberService();

		if (p_id != null)
			productDTO = pservice.productRetrieve(p_id);
		if (productDTO != null) {
			golfScoreDTO = golfccService.getGolfccScoreOne(productDTO.getCc_id());
			memberDTO = memberService.getMemberInfo(productDTO.getUser_no());
		}

		// 리퀘스트반환
		request.setAttribute("productDTO", productDTO);
		request.setAttribute("Golfcc", golfScoreDTO);
		request.setAttribute("Seller", memberDTO);
	}

}
