package com.squirrel.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.CcScoreDTO;
import com.squirrel.dto.view.RecommentViewDTO;
import com.squirrel.dto.view.ReviewListDTO;
import com.squirrel.service.ReCommentService;
import com.squirrel.service.ReviewListService;

@WebServlet("/ReviewDetailServlet")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String score_no = request.getParameter("score_no");
		String user_no = request.getParameter("user_no");
		if(score_no==null && user_no==null) {
			
		}
		ReviewListService service = new ReviewListService();
		CcScoreDTO dto = service.selectDetail(Integer.parseInt(score_no));
		
		Cookie[] cookies = request.getCookies();
		
		// 비교하기 위한 새로운 쿠키
		Cookie viewCookie = null;
		// 쿠키가 있을 경우 : 존재하는 쿠키와 비교할 이름이 같으면 viewCookie에 이름 저장
		if(cookies != null && cookies.length>0) {
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("cookie"+score_no)) {
					viewCookie = cookies[i];
				}
			}
		}
		// 쿠키가 없을 경우 : 새 쿠키를 생성하여 이름을 넣고 쿠키를 저장, 쿠키 저장시간 : 24시간, 조회수 증가
		if(viewCookie==null) {
			Cookie newCookie = new Cookie("cookie"+score_no, score_no);
			response.addCookie(newCookie);
			newCookie.setMaxAge(1*24*60*60);
			service.rv_vcount(Integer.parseInt(score_no));
		}
		ReviewListDTO rdto = service.selectNickname(Integer.parseInt(score_no));
		String nickname = rdto.getNickname();
		
		ReCommentService service2 = new ReCommentService();
		List<RecommentViewDTO> list = service2.selectRecomment(Integer.parseInt(score_no));
		
		request.setAttribute("reviewdetail", dto);
		request.setAttribute("recommentList", list);
		//request.setAttribute("user_no", Integer.parseInt(user_no)); // 글 내용 작성자와 로그인 한 사람 비교를 위해 넘김
		request.setAttribute("nickname", nickname);
		
		request.getRequestDispatcher("review/reviewDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
