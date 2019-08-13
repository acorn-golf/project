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
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.collections.MappingChange.Map;

/**
 * Servlet implementation class OauthServlet
 */
@WebServlet("/Oauth")
public class OauthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// TODO Auto-generated method stub
		Enumeration<String> keyVal = request.getParameterNames();

		while (keyVal.hasMoreElements())
			System.out.println("키값 : " + keyVal.nextElement());

		// response.setContentType("text/html;charset=UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		// mapper.readValue(src, valueType)

		// 테스트 부분

		BufferedReader br = null;
		URL url = new URL("https://kapi.kakao.com/v1/user/access_token_info?access_token="
				+ request.getParameter("access_token"));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		if (con.getResponseCode() == 200)
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		br.close();
		System.out.println(res.toString());

		java.util.Map<String, String> kakaoLoginInfo = new HashMap<String, String>();

		kakaoLoginInfo = mapper.readValue(res.toString(), new TypeReference<java.util.Map<String, String>>() {
		});

		for (String string : kakaoLoginInfo.keySet())
			System.out.println(string + ":" + kakaoLoginInfo.get(string));

		// 토큰값에 따라
		int errer_code;
		boolean login_success;
		boolean refresh_chk;
		if (Integer.parseInt(kakaoLoginInfo.get("expiresInMillis")) <= 0) {
			// 제인증 토큰 요청

		}

		java.util.Map<String, String> kakaoLoginResult = new HashMap<String, String>();
		kakaoLoginResult.put("login_success", "");
		kakaoLoginResult.put("refresh_chk", "");
		kakaoLoginResult.put("errer_code", "");

		String kakaoLoginResultS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(kakaoLoginResult);

		//

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

	private void curl(String urlStr, boolean postChk, java.util.Map<String, String> parameter,
			Consumer<Integer> action) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		BufferedReader br = null;
		StringBuffer urlBuffer = new StringBuffer();
		urlBuffer.append(urlStr);

		boolean firstChk = true;

		for (String parameterName : parameter.keySet()) {

			if (firstChk) {
				urlBuffer.append("?");
				firstChk = !firstChk;
			} else
				urlBuffer.append("&");

			urlBuffer.append(parameterName);
			urlBuffer.append("=");
			urlBuffer.append(parameter.get(parameterName));

		}
		URL url = new URL(urlBuffer.toString());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		if (postChk)
			con.setRequestMethod("POST");
		else
			con.setRequestMethod("GET");
		
		if (con.getResponseCode() == 200)
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		br.close();
		System.out.println(res.toString());

		java.util.Map<String, String> kakaoLoginInfo = new HashMap<String, String>();

		kakaoLoginInfo = mapper.readValue(res.toString(), new TypeReference<java.util.Map<String, String>>() {
		});

		for (String string : kakaoLoginInfo.keySet())
			System.out.println(string + ":" + kakaoLoginInfo.get(string));
	}

}
