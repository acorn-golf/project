package com.squirrel.controller.golfcc;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.dto.MemberDTO;
import com.squirrel.service.GolfccService;

/**
 * Servlet implementation class LikeGolfccAddServlet
 */
@WebServlet("/LikeGolfccSetServlet")
public class LikeGolfccSetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GolfccService golfccService = new GolfccService();
		
		String LikeChk = request.getParameter("LikeChk");
		String cc_id =  request.getParameter("cc_id");
		MemberDTO dto =(MemberDTO)request.getSession().getAttribute("login");
		String mesg = "";
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		response.setContentType("text/html;charset=UTF-8");
		
		map.put("cc_id", cc_id);
		map.put("user_no", dto.getUser_no());
		
		if(LikeChk=="Y") {
			mesg+="{";
			try {
				golfccService.LikeGolfccRemove(map);
				mesg+="'mesg':'찜목록에서 삭제되었습니다.'";
				mesg +=",'img':'/teamSquirrel/GOLFCC/sub/likeButton_off.png'";
			} catch (Exception e) {
				// TODO: handle exception
				mesg+="'mesg':'에러발생'";
				mesg+=",'errchk':'Y'";
			}finally{
				mesg +="}";
			}
			
		}
		else if (LikeChk=="N")
		{
			mesg+="{";
			try {
				golfccService.LikeGolfccAdd(map);
				mesg+="'mesg':'찜목록에 추가되었습니다.'";
				mesg +=",'img':'/teamSquirrel/GOLFCC/sub/likeButton_on.png'";
			} catch (Exception e) {
				// TODO: handle exception
				mesg+="'mesg':'에러발생'";
				mesg+=",'errchk':'Y'";
			}finally{
				mesg +="}";
			}
		}

		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
