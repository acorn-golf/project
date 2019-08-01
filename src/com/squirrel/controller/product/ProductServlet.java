package com.squirrel.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.LocationDTO;
import com.squirrel.dto.MemberDTO;
import com.squirrel.service.LocationService;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비로그인 필터 적용해야함 -> 한뉘가 필터로 등급에따른 접근처리도 한다했으니까 기다렷다가 하면 그거받자
		HttpSession session = request.getSession();
		MemberDTO loginInfo = (MemberDTO)session.getAttribute("login");
//		System.out.println(loginInfo.getRating());
		if(loginInfo.getRating().equals("M")) {
			LocationService service = new LocationService();
			List<LocationDTO> list = service.locationList();
			
			request.setAttribute("LocationList", list);
			request.getRequestDispatcher("product/product.jsp").forward(request, response);
		}else {
			session.setAttribute("productmesg", "권한이 없습니다");
			response.sendRedirect("main.jsp");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
