package com.squirrel.controller.Member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.service.MemberService;



@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		String phone_id = request.getParameter("phoneid");
		String userpw = request.getParameter("password");
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String userssn = request.getParameter("userssn");
		String gender = request.getParameter("gender");
		String emailid = request.getParameter("emailid");
		String emailadd = request.getParameter("emailadd");
		String s_emailadd = request.getParameter("S_emailadd");
		String rating = request.getParameter("rating");
		String email;

		if(emailadd == ""){
			email = emailid+"@"+s_emailadd;
		}else {
			email = emailid+"@"+emailadd;
		}			
		if(gender.equals("male")) {
			gender = "1";
		}else {
			gender = "2";
		}
		MemberDTO dto = new MemberDTO(phone_id, userpw, username, nickname, userssn, gender, rating, email);
		
		MemberService service = new MemberService();
		int confirm = service.MemberAdd(dto);
		
		if(confirm == 0) {
			RequestDispatcher dis = request.getRequestDispatcher("MemberUIServlet");
			dis.forward(request, response);
		}else {
		
			HttpSession session = request.getSession();
			session.setAttribute("login", dto);				
			response.sendRedirect("member/memberWelcome.jsp");
		
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
