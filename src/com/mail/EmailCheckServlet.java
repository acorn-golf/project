package com.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.squirrel.dto.MemberDTO;
import com.squirrel.service.MemberService;
import com.squirrel.util.aes.AESManager;

@WebServlet("/EmailCheckServlet")
public class EmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isTime = request.getParameter("isTime");
		isTime = java.net.URLDecoder.decode(isTime,"UTF-8");
		//enco = java.net.URLDecoder.decode(enco,"UTF-8");
		String isCode = request.getParameter("isCode");
		isTime = isTime.replace(" ", "+");
		System.out.println("인식한 문자열 : "+isTime);
		isTime = AESManager.getMyAes().deCodeText(isTime);
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		try {
			Date userTime = format.parse(isTime);
			long chkTime = (curDate.getTime()-userTime.getTime())/(24*60*60*1000);
			
			if(chkTime<1) {
				HashMap<String , Integer> emailchk = (HashMap<String , Integer>)getServletContext().getAttribute("emailchk");
				int user_no = emailchk.get(isCode);

				MemberService service = new MemberService();
				service.updateEmail(user_no);
				
				if(request.getSession().getAttribute("login")==null) { // 기존 브라우저 끄거나 달라졌을 때 로그인이 null일 수 있다
					MemberDTO dto = service.getUser(user_no);
					request.getSession().setAttribute("login", dto);
				}
				out.print("<html><script>alert('성공')</script></html>");
				request.getSession().setAttribute("mesg", "성공");
				response.sendRedirect("main.jsp"); // 성공페이지
				
			}else {
				out.print("<html><script>alert('실패 \n 인증 시간이 지났습니다\n 인증시간 : 24시간\n 마이페이지에서 이메일인증을 진행하세요')</script></html>");
				request.getSession().setAttribute("mesg", "실패 \n 인증 시간이 지났습니다\n 인증시간 : 24시간\n 마이페이지에서 이메일인증을 진행하세요");
				String mesg = "";
				//request.setAttribute("errormesg", mesg);
				response.sendRedirect("main.jsp"); // 실패 페이지
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
