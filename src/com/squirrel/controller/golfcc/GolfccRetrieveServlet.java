package com.squirrel.controller.golfcc;

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
@WebServlet("/GolfccRetrieveServlet")
public class GolfccRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		golfccRetrieve(request, response);
		
		
		request.getRequestDispatcher("Golfcc/productRetrieve.jsp").forward(request, response);

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

	private void golfccRetrieve(HttpServletRequest request, HttpServletResponse response) {
		String cc_id = request.getParameter("cc_id");	
		
		

		CcGolfScoreDTO golfScoreDTO = null;


		GolfccService golfccService = new GolfccService();


		if (cc_id != null)
			golfScoreDTO = golfccService.getGolfccScoreOne(cc_id);


		// 리퀘스트반환
		request.setAttribute("Golfcc", golfScoreDTO);
	}

}
