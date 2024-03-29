package com.mail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squirrel.service.MemberService;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/SendPWMailServlet")
public class SendPWMailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneid = request.getParameter("phoneid");
		String email = request.getParameter("email");
		
		Random random = new Random();
		String[] pwval = new String [7];
		String pw="";
		for(int i=0;i<pwval.length;i++) {
			pwval[i]=String.valueOf(random.nextInt(9));
			pw += pwval[i]; 
		}
		
		// Member테이블에서 phoneid로 해당 검색을해서 비밀번호를 pw 로 update 하는 구문 적어야함
		MemberService service = new MemberService();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userpw", pw);
		map.put("phone_id", phoneid);
		service.updatePW(map);
	
		String host = "smtp.naver.com";
	    String subject = "GolfHi 임시비밀번호 발송";
	    String from = "tlakffja@naver.com"; //보내는 메일
	   String fromName = "GolfHi";
	    String to = email; //받는 메일
	    String content ="<h2>안녕하세요 MS :p GolfHi 입니다!</h2><br><br>" 
	    		+"임시비밀번호: "+pw;

	   try{
	     //프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
	     Properties props = new Properties();
	     //네이버 SMTP 사용시
	    props.put("mail.smtp.starttls.enable","true");
	     props.put("mail.transport.protocol","smtp");
	     props.put("mail.smtp.host", host);
	     
	     props.put("mail.smtp.port","465");  // 보내는 메일 포트 설정
	    props.put("mail.smtp.user", from);
	     props.put("mail.smtp.auth","true");
	     props.put("mail.smtp.debug", "true");
	     props.put("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	     props.put("mail.smtp.socketFactory.fallback", "false");


	     Authenticator auth = new SendMail();
	     Session mailSession = Session.getDefaultInstance(props,auth);
	   
	     Message msg = new MimeMessage(mailSession);
	     msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
	    InternetAddress[] address = {new InternetAddress(to)};
	    
	     msg.setRecipients(Message.RecipientType.TO, address); //받는 사람설정
	   
	     msg.setSubject(subject); //제목설정
	    msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
	    msg.setContent(content,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
	    
	     Transport.send(msg); //메일 보내기

	     }catch(MessagingException ex){
	      System.out.println("mail send error : "+ex.getMessage());
	       ex.printStackTrace();
	     }catch(Exception e){
	      System.out.println("error : "+e.getMessage());
	       e.printStackTrace();
	     }
	   
	   request.setAttribute("email", email);
	   request.getRequestDispatcher("email/sendEmail.jsp").forward(request, response);
	   
	}//end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
