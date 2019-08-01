package com.squirrel.controller.Member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.service.MemberService;

@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone_id = request.getParameter("phoneid");
		String nickname = request.getParameter("nickname");
		
		MemberService service = new MemberService();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("phone_id", phone_id);
		map.put("nickname", nickname);
		int confirm = service.idCheck(map);	
		response.getWriter().print(confirm);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
