package com.squirrel.controller.Member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.dto.MemberDTO;
import com.squirrel.service.MemberService;

@WebServlet("/PhoneIdCheckServlet")
public class PhoneIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone_id = request.getParameter("phoneid");
		MemberService service = new MemberService();
		MemberDTO dto = service.getPhoneUser(phone_id);
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		Map<String, String> map = new HashMap<String,String>();
		if(dto==null) {
			map.put("phoneid", "정보없음");
			map.put("email", "정보없음");
			map.put("email_chk", "정보없음");
		}else {
			map.put("phoneid", dto.getPhone_id());
			map.put("email", dto.getEmail());
			map.put("email_chk", dto.getEmail_chk());
		}
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
