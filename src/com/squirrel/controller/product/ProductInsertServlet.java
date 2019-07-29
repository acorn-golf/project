package com.squirrel.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductInsertServlet")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		P_ID  넘버링
//		P_PDATE 상품 조인시간
//		P_UPLOADDATE 상품 등록한 시간
//		P_MAXPEOPLE 최대인원
//		P_HOLE 홀 수
//		P_CADDYYN 캐디 유무
//		P_BABYN 식사 유무
//		P_CARTYN 카트 유무
//		P_PRICE 상품가격
//		P_CONTENT 상품 내용
//		USER_NO 유저id
//		CC_ID 골프장 아이디
//		P_VCOUNT 조회수(일반유저가 검색했을 때 넘버링)
		String p_id = null; // pk 자동넘버링
		String p_pdate = request.getParameter("date").concat(request.getParameter("time"));
		String p_uploaddate = null; // default가 sysdate
		String p_maxpeople = request.getParameter("p_maxpeople");
		String p_hole = request.getParameter("p_hole");
		String p_caddyyn = request.getParameter("p_caddyyn");
		String p_bobyn = null;
		if(request.getParameter("p_babyn")==null) {
			p_bobyn = "N";
		}else if(request.getParameter("p_babyn").equals("on")){
			p_bobyn = "Y";
		}
		String p_cartyn = null;
		if(request.getParameter("p_cartyn")==null) {
			p_cartyn = "N";
		}else if(request.getParameter("p_cartyn").equals("on")){
			p_cartyn = "Y";
		}
		String p_price = request.getParameter("p_price");
		String p_content = request.getParameter("p_content");
		//userid는 세션으로 따올거
		String cc_id = request.getParameter("cc_id");
		System.out.println(p_id); // null
		System.out.println(p_pdate); // 2019~~~19:00
		System.out.println(p_uploaddate); //null
		System.out.println(p_maxpeople); //4
		System.out.println(p_hole); //18
		System.out.println(p_caddyyn); //N
		// 체크박스 bob, cart 는 체크된상태로 넘어오면 on, 체크안된상태로 넘어오면 null
		System.out.println(p_bobyn); // Y or N
		System.out.println(p_cartyn); // Y or N
		System.out.println(p_price); //5
		System.out.println(p_content); // 내용 잘 나옴
		System.out.println(cc_id); // cc_id 잘 나옴
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
