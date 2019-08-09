package com.squirrel.controller.Member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.service.MemberService;

@WebServlet("/MultiCheckServlet")
public class MultiCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone_id = request.getParameter("phoneid");
		String userpw = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		
		MemberService service = new MemberService();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("phone_id", phone_id);
		map.put("userpw", userpw);	
		map.put("nickname", nickname);
		map.put("email", email);		
		int confirm = service.multiCheck(map);	
		response.getWriter().print(confirm);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
