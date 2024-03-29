package com.squirrel.controller.oauth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.rewrite.RewriteMap;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.dto.MemberDTO;
import com.squirrel.service.MemberService;
import com.squirrel.util.curl.CurlUtil;
import com.sun.javafx.collections.MappingChange.Map;

/**
 * Servlet implementation class OauthServlet
 */
@WebServlet("/Oauth")
public class OauthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService memberService = new MemberService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OauthServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Enumeration<String> keyVal = request.getParameterNames();
//		while (keyVal.hasMoreElements())
//			System.out.println("키값 : " + keyVal.nextElement());

		java.util.Map<String, Object> kakaoLoginInfo = null;

		HashMap<String, String> parmeterMap = new HashMap<String, String>();
		parmeterMap.put("access_token", request.getParameter("access_token"));
		HttpSession httpSession = request.getSession();

		kakaoLoginInfo = CurlUtil.Getmy().curlReturnMap("https://kapi.kakao.com/v1/user/access_token_info", false,
				parmeterMap, (code, resultparmeter) -> {

					ObjectMapper mapper2 = new ObjectMapper();
					MemberDTO dto = null;

					java.util.Map<String, Object> resultmap = new HashMap<String, Object>();
					int errer_code = 0;
					boolean login_success;
					boolean refresh_chk;
					String err_mesg = null;

					

					switch (code) {
					case 200:
						login_success = true;
						refresh_chk = false;
						System.out.println(resultparmeter.get("id"));
						dto = memberService.kakaoLogin(resultparmeter.get("id").toString());

						if (dto == null) {
							int chk = kakaoMemberAdd("Bearer " + request.getParameter("access_token"));
							if (chk > 0) {
								dto = memberService.kakaoLogin(resultparmeter.get("id").toString());
								httpSession.setAttribute("login", dto);
								err_mesg = "회원가입 실패 관리자에게 문의하세요";
								errer_code = 666;
							}else
								login_success = false;
						} else
							httpSession.setAttribute("login", dto);

						break;

					case -401:
						login_success = false;
						refresh_chk = true;
						errer_code = -401;
						break;

					case -2:
						login_success = false;
						refresh_chk = false;
						errer_code = -2;
						err_mesg = "잘못된 토큰 형식";
						break;

					case -1:
						login_success = false;
						refresh_chk = false;
						errer_code = -1;
						err_mesg = "카카오 서버 오류 잠시후에 다시 시도해주세요.";
						break;

					default:
						errer_code = code;
						login_success = false;
						refresh_chk = false;
						err_mesg = "알수 없는 오류. 관리자에게 문의해주세요";
						break;
					}

					resultmap.put("errer_code", String.valueOf(errer_code));
					resultmap.put("login_success", String.valueOf(login_success));
					resultmap.put("refresh_chk", String.valueOf(refresh_chk));
					if (err_mesg != null)
						resultmap.put("err_mesg", err_mesg);

					httpSession.setAttribute("resultmap", resultmap);

					return resultmap;
				});
		
		String JsonStr; 
		JsonStr = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(kakaoLoginInfo);
		response.getWriter().print(JsonStr);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private int kakaoMemberAdd(String access_token) {
		HashMap<String, String> inValue = new HashMap<String, String>();
		inValue.put("Authorization", access_token);
		int chk = 0;

		java.util.Map<String, Object> resultMap = null;
		resultMap = CurlUtil.Getmy().curlReturnMap("https://kapi.kakao.com/v2/user/me", true, inValue, null);

		HashMap<String, Object> properties = (HashMap<String, Object>) resultMap.get("properties");
		HashMap<String, Object> kakao_account = (HashMap<String, Object>) resultMap.get("kakao_account");

		MemberDTO dto = new MemberDTO();
		if ((boolean) kakao_account.get("has_email"))
			;

		dto.setEmail((String) kakao_account.get("email"));
		System.out.println(dto.getEmail());

		String email_chk = ((boolean) kakao_account.get("is_email_verified")) ? "Y" : "N";
		dto.setEmail_chk(email_chk);

		dto.setUsername((String) properties.get("nickname"));
		dto.setNickname((String) properties.get("nickname"));// gender_needs_agreement

		dto.setKakao_id(String.valueOf((Integer)resultMap.get("id")));

		if ((boolean) kakao_account.get("has_gender"))// female
		{
			String i = "1";

			if (((String) kakao_account.get("gender")).equals("female"))
				i = "2";
			dto.setGender(i);
		}

		chk = memberService.kakaoMemberAdd(dto);

		return chk;

	}

}
