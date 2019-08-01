package com.squirrel.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.CcScoreDTO;
import com.squirrel.service.ReviewListService;

@WebServlet("/UpdateReviewDetailServlet")
public class UpdateReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String score_no = request.getParameter("score_no");
		String user_no = request.getParameter("user_no");
		String score = request.getParameter("score");
		String rv_title = request.getParameter("rv_title");
		String rv_content = request.getParameter("rv_content");
		
		CcScoreDTO cdto = new CcScoreDTO();
		cdto.setScore(Integer.parseInt(score));
		cdto.setRv_title(rv_title);
		cdto.setRv_content(rv_content);
		cdto.setScore_no(Integer.parseInt(score_no));
		
		ReviewListService service = new ReviewListService();
		service.updateReview(cdto);
		
		request.setAttribute("score_no", score_no);
		request.setAttribute("user_no", user_no);
		request.getRequestDispatcher("ReviewDetailServlet").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
