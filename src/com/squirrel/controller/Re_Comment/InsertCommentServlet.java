package com.squirrel.controller.Re_Comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.ReCommentDTO;
import com.squirrel.service.ReCommentService;

@WebServlet("/InsertCommentServlet")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String score_no = request.getParameter("score_no");
		String user_no = request.getParameter("user_no");
		String re_content = request.getParameter("re_content");
		
		ReCommentDTO dto = new ReCommentDTO();
		dto.setScore_no(Integer.parseInt(score_no));
		dto.setUser_no(Integer.parseInt(user_no));
		dto.setRe_content(re_content);
		
		ReCommentService service = new ReCommentService();
		int n = service.insertComment(dto);
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(n!=0) {
			out.print("등록되었습니다");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
