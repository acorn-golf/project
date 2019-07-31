package com.squirrel.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.CcScoreDTO;
import com.squirrel.dto.view.ReviewListDTO;
import com.squirrel.service.ReviewListService;

@WebServlet("/UpdateReviewformServlet")
public class UpdateReviewformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String score_no = request.getParameter("score_no");
		ReviewListService service = new ReviewListService();
		CcScoreDTO cdto = service.selectDetail(Integer.parseInt(score_no));
		
		ReviewListDTO rdto = service.selectNickname(Integer.parseInt(score_no));
		String nickname = rdto.getNickname();

		request.setAttribute("reviewdetail", cdto);
		request.setAttribute("nickname", nickname);
		request.getRequestDispatcher("review/updateReviewform.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
