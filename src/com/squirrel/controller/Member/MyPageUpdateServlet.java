package com.squirrel.controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.service.MemberService;

@WebServlet("/MyPageUpdateServlet")
public class MyPageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String phone_id = request.getParameter("phoneid");
		String userpw = request.getParameter("password");
		String email = request.getParameter("email");		
		
		HttpSession session = request.getSession();
		MemberDTO dto = new MemberDTO(phone_id, userpw, email);
		MemberService service = new MemberService();
		
		int confirm = service.myPageUpdate(dto);
		String destination = "MyPageServlet";
		if(confirm == 0) {
			dto = (MemberDTO)session.getAttribute("login");
			request.getRequestDispatcher(destination).forward(request, response);
			
		}else {
			dto = (MemberDTO)session.getAttribute("login");
			String nickname = dto.getNickname();
			dto = service.myPage(nickname);
			session.setAttribute("login", dto);
			response.sendRedirect(destination);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
