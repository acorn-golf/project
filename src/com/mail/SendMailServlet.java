package com.mail;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.util.aes.AES256Util;
import com.squirrel.util.aes.AESManager;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {

	// 파라미터로 넘어온 문자열을 해쉬코드값으로 변경(MD5 : 128bit)
	public String testMD5(String str) {
		String MD5 = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			MD5 = null;
		}
		return MD5;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDTO user = (MemberDTO) request.getSession().getAttribute("login");
		String username = user.getUsername();

		// 시간 변수 설정 나중에 db에서 가져올것.
		Date dateTmp = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 임시방편. 나중에 date 변수에 sql에서 가져온 시간값(문자열) 삽입할 것.
		// format.parse(source) -> 시간비교시 확인
		String date = format.format(dateTmp);
		// 시간 설정 끝
		String code = date +"/"+ user.getUser_no();

		// 서블릿 ? 시간 = aes암호화값 & 개별코드 = 시간+유저아이디 해쉬값

		String enco = AESManager.getMyAes().enCodeText(date);
		String dnco = AESManager.getMyAes().deCodeText(enco);
//		System.out.println(dnco);

		String iscode = testMD5(code);

		//enco = enco.replace("+", "&#43;");
//		//enco = enco.replace("=", "&#61;");
//		//enco = enco.replace("%", "&#37;");
		//enco = enco.replace("&","&amp;");
		//enco= java.net.URLEncoder.encode(enco, "UTF-8");
		//String testcfoot = java.net.URLEncoder.encode("&#43;", "UTF-8");
		
		System.out.println("암호화 변환 text:"+enco);
		

		HashMap<String, Integer> emailchk = (HashMap<String, Integer>) getServletContext().getAttribute("emailchk");
		if (emailchk == null) {
			emailchk = new HashMap<String, Integer>();
			getServletContext().setAttribute("emailchk", emailchk);
		}

		emailchk.put(iscode, user.getUser_no());
		
		String host = "smtp.naver.com";
		String subject = "GolfHi 이메일 인증";
		String from = "tlakffja@naver.com"; // 보내는 메일
		String fromName = "GolfHi관리자";
		String to = "wlgkssnl@naver.com"; // 받는 메일
		String content = "<h2>안녕하세요 MS :p GolfHi 입니다!</h2><br><br>" + "<h3>" + username + "님</h3>"
				+"<p>인증하기 버튼을 누르시면 비밀번호 분실 시 이메일을 통해 확인할 수 있습니다</p>"
				+"<form action='EmailCheckServlet' method='post'>"
				+"<input type='hidden' name='isTime' value='"+enco+"'>"
				+"<input type='hidden' name='isCode' value='"+iscode+"'>"
				+"<input type='submit' value='인증하기'>"
				+"</form>"
				+"<a href='localhost:8090/teamSquirrel/EmailCheckServlet?isTime="+enco+"&isCode="+iscode+"'>인증하기</a>"

				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";

		try {
			// 프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
			Properties props = new Properties();
			// 네이버 SMTP 사용시
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);

			props.put("mail.smtp.port", "465"); // 보내는 메일 포트 설정
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			Authenticator auth = new SendMail();
			Session mailSession = Session.getDefaultInstance(props, auth);

			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 보내는 사람 설정
			InternetAddress[] address = { new InternetAddress(to) };

			msg.setRecipients(Message.RecipientType.TO, address); // 받는 사람설정

			msg.setSubject(subject); // 제목설정
			msg.setSentDate(new java.util.Date()); // 보내는 날짜 설정
			msg.setContent(content, "text/html; charset=UTF-8"); // 내용 설정(MIME 지정-HTML 형식)

			Transport.send(msg); // 메일 보내기

		} catch (MessagingException ex) {
			System.out.println("mail send error : " + ex.getMessage());
			ex.printStackTrace();
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
			e.printStackTrace();
		}
		
		response.sendRedirect("email/sendEmail.jsp");

	}// end doGet

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
