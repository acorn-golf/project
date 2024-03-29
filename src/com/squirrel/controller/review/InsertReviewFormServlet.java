package com.squirrel.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.LocationDTO;
import com.squirrel.service.LocationService;

@WebServlet("/InsertReviewFormServlet")
public class InsertReviewFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String cc_id = request.getParameter("cc_id");
//		System.out.println(cc_id);
//		request.setAttribute("cc_id", cc_id);
		
		LocationService service = new LocationService();
		List<LocationDTO> list = service.locationList();
		request.setAttribute("LocationList", list);
		
		request.getRequestDispatcher("review/insertReviewForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
