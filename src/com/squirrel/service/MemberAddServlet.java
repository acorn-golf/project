package com.squirrel.service;

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
		
		String phone_id = request.getParameter("phone_id");
		String userpw = request.getParameter("userpw");
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String userssn = request.getParameter("userssn");
		String gender = request.getParameter("gender");
		String emailid = request.getParameter("emailid");
		String emailadd = request.getParameter("emailadd");
		String s_emailadd = request.getParameter("S_emailadd");
		String email = null;
		
		if(emailadd == ""){
			email = emailid+"@"+s_emailadd;
		}else {
			email = emailid+"@"+emailadd;
		}		
		
		if(gender == "male") {
			gender = "1";
		}else {
			gender = "2";
		}
		MemberDTO dto = new MemberDTO(phone_id, userpw, username, nickname, userssn, gender, email);
		
		MemberService service = new MemberService();
		int confirm = service.MemberAdd(dto);		
		
		if(confirm == 0) {
			RequestDispatcher dis = request.getRequestDispatcher("memberForm.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("dto", dto);
			response.sendRedirect("memberWelcome.jsp");
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
