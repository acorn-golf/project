package com.squirrel.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.service.ReviewListService;

@WebServlet("/DeleteReviewDeatilServlet")
public class DeleteReviewDeatilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String score_no = request.getParameter("score_no");
		
		ReviewListService service = new ReviewListService();
		service.deleteReview(Integer.parseInt(score_no));
		
		// ReviewListServlet로 보내기 위해선 cc_id가 필요 따라서 상품자세히보기 페이지로 보내는게 맞다 지금은 임시방편
		request.getRequestDispatcher("ReviewListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
