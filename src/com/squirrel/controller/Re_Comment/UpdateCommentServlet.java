package com.squirrel.controller.Re_Comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.service.ReCommentService;

@WebServlet("/UpdateCommentServlet")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String re_no = request.getParameter("re_no");
		String re_content = request.getParameter("re_content");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("re_no", re_no);
		map.put("re_content", re_content);
		ReCommentService service = new ReCommentService();
		int n = service.updateComment(map);
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(n!=0) {
			out.print("수정되었습니다");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
