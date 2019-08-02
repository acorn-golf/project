package com.squirrel.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.squirrel.dto.CcScoreDTO;
import com.squirrel.dto.MemberDTO;
import com.squirrel.service.ReviewListService;

@WebServlet("/InsertReviewServlet")
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션처리 및 세션의 유저pk usern_no 갖고와야됨
		HttpSession session = request.getSession();
		MemberDTO user = (MemberDTO)session.getAttribute("login");
		int score_no = 0; // mapper에서 시퀀스 준다
		String score = request.getParameter("score"); // int로 형변환
		String cc_id = request.getParameter("cc_id");
		String score_date = null; // default가 sysdate라서 mapper에서 적용 안함
		int user_no = user.getUser_no(); // 세션에서 받아와야됨 : session.getAttribute("login").user_no
		String rv_content = request.getParameter("rv_content");
		String rv_title = request.getParameter("rv_title");
		int rv_vcount = 0; // 조회수 이므로 insert할 때 적용 안함 -> mapper에서 적용 안한다
		
		CcScoreDTO dto = new CcScoreDTO(score_no, Integer.parseInt(score), cc_id, score_date, user_no, rv_title, rv_content, rv_vcount);
		ReviewListService service = new ReviewListService();
		service.insertReview(dto);
		
		response.sendRedirect("ReviewListServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
