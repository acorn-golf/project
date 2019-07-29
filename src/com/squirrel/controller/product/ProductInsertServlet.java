package com.squirrel.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.ProductDTO;
import com.squirrel.service.ProductService;

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
		String p_id = null; // 상품아이디, pk 자동넘버링
		String p_pdate = request.getParameter("date").concat("/").concat(request.getParameter("time")); // 티업시간
		String p_uploaddate = null; // 상품등록날짜, default가 sysdate
		String p_maxpeople = request.getParameter("p_maxpeople"); // 최대인원, int로 형변환
		String p_hole = request.getParameter("p_hole"); // 홀 수, int로 형변환
		String p_caddyyn = request.getParameter("p_caddyyn"); // 캐디유무
		String p_babyn = null; // 식사포함, 기본값 : N
		if(request.getParameter("p_babyn")==null) {
			p_babyn = "N";
		}else if(request.getParameter("p_babyn").equals("on")){
			p_babyn = "Y";
		}
		String p_cartyn = null; // 카트비포함, 기본값 : N
		if(request.getParameter("p_cartyn")==null) {
			p_cartyn = "N";
		}else if(request.getParameter("p_cartyn").equals("on")){
			p_cartyn = "Y";
		}
		String p_price = request.getParameter("p_price"); // 상품가격, int로 형변환
		String p_content = request.getParameter("p_content"); // 상품내용
		int user_no = 3; // 매니저 pk, 임의로 메니저의 pk를 넣을거다 => 원래는 세션의 로그인 정보 확인후 해당 세션의 pk검색해서 넣어야됨
		String cc_id = request.getParameter("cc_id"); // 골프장 pk
		int p_vcount=0; // 조회수, 사용자가 상품 조회시 자동 시퀀스 넘버링
		
		ProductDTO dto = new ProductDTO(p_id, p_pdate, p_uploaddate, Integer.parseInt(p_maxpeople), Integer.parseInt(p_hole), p_caddyyn, p_babyn, p_cartyn, Integer.parseInt(p_price), p_content, user_no, cc_id, p_vcount);
		ProductService service = new ProductService();
		service.productInsert(dto);
		
		response.sendRedirect("ProductServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
