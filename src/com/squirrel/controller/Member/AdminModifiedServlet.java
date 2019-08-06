package com.squirrel.controller.Member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.service.MemberService;
import com.squirrel.service.ProductService;

@WebServlet("/AdminModifiedServlet")
public class AdminModifiedServlet extends HttpServlet {
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
			String phone_id = request.getParameter("phoneid");
			String username = request.getParameter("username");
			String usernick = request.getParameter("nickname");
			String userssn = request.getParameter("userssn");
			String rating = request.getParameter("rating");
			String rstartdate = request.getParameter("rstartdate");
			String renddate = request.getParameter("renddate");
			String email = request.getParameter("email");
			
			destination = "member/adminPage.jsp";			
			session.setAttribute("login", dto);
			request.getRequestDispatcher(destination).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
