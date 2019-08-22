package com.squirrel.controller.Member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.service.MemberService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone_id = request.getParameter("phoneid");
		String userpw = request.getParameter("password");

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("phone_id", phone_id);
		map.put("userpw", userpw);
		
		MemberService service = new MemberService();
		MemberDTO dto = service.login(map);
		
		if(dto == null) {
			response.sendRedirect("member/loginForm.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("login", dto);
			
			request.getRequestDispatcher("email/isEmailchk.jsp").forward(request, response);
			
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
