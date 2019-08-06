package com.squirrel.controller.Picklist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.PickListDTO;
import com.squirrel.service.PickService;

@WebServlet("/InsertPickListServlet")
public class InsertPickListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String p_id = request.getParameter("p_id"); // 상품 자세히 보기에서 찜목록에 추가하였을 시 받을 파라미터
		String pick_amount = request.getParameter("p_maxpeople");// 예약인원, 상품 자세히 보기에서 찜목록에 추가하였을 시 받을 파라미터
		MemberDTO user = (MemberDTO)session.getAttribute("login");
		int user_no = user.getUser_no();
		System.out.println(user_no);
		PickListDTO dto = new PickListDTO();
		dto.setP_id("p24");
		dto.setPick_amount(2);
		dto.setUser_no(user_no);
		
		PickService service = new PickService();
		service.insertPick(dto);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
