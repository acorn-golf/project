package com.squirrel.controller.Notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;


@WebServlet("/NoticeUIService")
public class NoticeUIService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public NoticeUIService() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session =request.getSession();
	 MemberDTO dto  = (MemberDTO)session.getAttribute("login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
