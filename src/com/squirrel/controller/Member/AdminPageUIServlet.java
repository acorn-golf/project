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

@WebServlet("/AdminPageUIServlet")
public class AdminPageUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String destination = null;
		if(dto == null) {
			destination = "LoginUIServlet";
			response.sendRedirect(destination);
		}else {
			String nickname = dto.getNickname();
			MemberService service = new MemberService();
			dto = service.myPage(nickname);
			destination = "member/adminPage.jsp";			
			session.setAttribute("login", dto);
			request.getRequestDispatcher(destination).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
