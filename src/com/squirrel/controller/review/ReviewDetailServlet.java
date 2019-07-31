package com.squirrel.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.CcScoreDTO;
import com.squirrel.service.ReviewListService;

@WebServlet("/ReviewDetailServlet")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String score_no = request.getParameter("score_no");
		String user_no = request.getParameter("user_no");
		String nickname = request.getParameter("nickname");
		ReviewListService service = new ReviewListService();
		CcScoreDTO dto = service.selectDetail(Integer.parseInt(score_no));
		
		request.setAttribute("reviewdetail", dto);
		request.setAttribute("user_no", Integer.parseInt(user_no));
		request.setAttribute("nickname", nickname);
		
		request.getRequestDispatcher("review/reviewDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
