package com.squirrel.controller.Re_Comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.service.ReCommentService;

@WebServlet("/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String re_no = request.getParameter("re_no");
		
		ReCommentService service = new ReCommentService();
		int n = service.deleteComment(re_no);
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(n!=0) {
			out.print("삭제되었습니다");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
