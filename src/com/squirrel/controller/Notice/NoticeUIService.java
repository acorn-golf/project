package com.squirrel.controller.Notice;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.NoticeListDTO;
import com.squirrel.service.MemberService;
import com.squirrel.service.NoticeService;

@WebServlet("/NoticeUIService")
public class NoticeUIService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeUIService() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("phone_id", dto.getPhone_id());
		map.put("userpw", dto.getUserpw());
		
		
		dto = new MemberService().login(map);
		
		// 여기서 부터 작성
		String note_content = request.getParameter("note_content");
	
		String note_title = request.getParameter("note_title");
	
		String notedate = request.getParameter("notedate");
		String note_division = request.getParameter("note_division");
		String note_file = "";//request.getParameter("note_file");
	
		
NoticeListDTO ndto = new NoticeListDTO(note_division, note_title, note_content);

ndto.setUser_no(dto.getUser_no());
		
NoticeService service = new NoticeService();
		int confirm = service.NoticeInsert(ndto);
		
		if(confirm == 0) {
			RequestDispatcher dis = request.getRequestDispatcher("note/Notice/Note.jsp");
			dis.forward(request, response);
		}else {
		
			HttpSession session1 = request.getSession();
			session1.setAttribute("login", dto);			
			response.sendRedirect("note/Notice/Note.jsp");}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
