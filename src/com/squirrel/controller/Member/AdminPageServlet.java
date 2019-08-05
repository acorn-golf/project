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

@WebServlet("/AdminPageServlet")
public class AdminPageServlet extends HttpServlet {
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
			ProductService pService = new ProductService();
			dto = service.myPage(nickname);
			String adminSelect = request.getParameter("adminSelect");
			String adminSearch = request.getParameter("adminSearch");
			String member = request.getParameter("member");
			
			List<MemberDTO> list = null;
			HashMap<String, String> map = new HashMap<String, String>();
			if( adminSelect.equals("member") ){				
				map.put("adminSearch",adminSearch);
				map.put("member",member);
				list = service.adminMemberSelect(map);	
			}else if( adminSelect.equals("product") ){
				
			}
			
			request.setAttribute("list", list);
			destination = "member/adminPage.jsp";			
			session.setAttribute("login", dto);
			request.getRequestDispatcher(destination).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
