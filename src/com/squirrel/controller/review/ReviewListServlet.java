package com.squirrel.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.CcScoreDTO;
import com.squirrel.dto.GolfCcDTO;
import com.squirrel.dto.ReviewDTO;
import com.squirrel.service.GolfccService;

@WebServlet("/ReviewListServlet")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션처리 및 상품자세히보기에서 파라미터를 받아야 한다
		// 세션에서 userno 를 받아 nickname을 적고, 상품자세히보기에서 해당 골프장 cc_id를 받아 cc_name을 적는다
		// score는 CCSCORE에서 찾아서 넣어야 한다
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
