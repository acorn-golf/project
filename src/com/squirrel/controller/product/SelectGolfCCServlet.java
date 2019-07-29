package com.squirrel.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.GolfCcDTO;
import com.squirrel.service.GolfccService;


@WebServlet("/SelectGolfCCServlet")
public class SelectGolfCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션처리 필요
		String loc_id = request.getParameter("loc_ID");
		
		GolfccService service = new GolfccService();
		List<GolfCcDTO> list = service.selectGolfccName(loc_id);
		
		String mesg = null;
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		for (GolfCcDTO g : list) {
			mesg += "<option value='"+g.getCc_id()+"'>"+g.getCc_name()+"</option>";
		}
		out.print(mesg);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
