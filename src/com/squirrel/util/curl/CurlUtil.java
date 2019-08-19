package com.squirrel.util.curl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.function.BiFunction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurlUtil {

	private ObjectMapper mapper = new ObjectMapper();

	static public CurlUtil my = new CurlUtil();

	static public CurlUtil Getmy() {
		return my;
	}

	public String curlReturnJsonStr(String urlStr, boolean postChk, Map<String, String> parameter,
			BiFunction<Integer, Map<String, Object>, Map<String, Object>> resultFun) {
		Map<String, Object> result = null;
		try {

			if (resultFun != null)
				result = curl(urlStr, postChk, parameter, resultFun);
			else
				result = curl(urlStr, postChk, parameter, (code, returnparameter) -> {
					return returnparameter;
				});
		} catch (IOException e) {

			e.printStackTrace();
		}

		String JsonStr = null;
		try {
			JsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return JsonStr;
	}

	public Map<String, Object> curlReturnMap(String urlStr, boolean postChk, Map<String, String> parameter,
			BiFunction<Integer, Map<String, Object>, Map<String, Object>> resultFun) {
		Map<String, Object> result = null;
		try {

			if (resultFun != null)
				result = curl(urlStr, postChk, parameter, resultFun);
			else
				result = curl(urlStr, postChk, parameter, (code, returnparameter) -> {
					return returnparameter;
				});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	

	private java.util.Map<String, Object> curl(String urlStr, boolean postChk, java.util.Map<String, String> parameter,
			BiFunction<Integer, java.util.Map<String, Object>, java.util.Map<String, Object>> resultFun)
			throws IOException {

		BufferedReader br = null;
		StringBuffer paramBuffer = new StringBuffer();
		// urlBuffer.append(urlStr);

		URL url = null;
		HttpURLConnection con = null;

		if (postChk) {
			url = new URL(urlStr);
			con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("POST");
			for (String key : parameter.keySet())
				con.setRequestProperty(key, parameter.get(key));
		} else {

			boolean firstChk = true;

			for (String parameterName : parameter.keySet()) {

				if (firstChk) { // urlBuffer.append("?"); firstChk = !firstChk; } else
					paramBuffer.append("&");
				}
				paramBuffer.append(parameterName);
				paramBuffer.append("=");
				paramBuffer.append(parameter.get(parameterName));

			}

			url = new URL(urlStr+"?"+paramBuffer.toString());
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
		}

		// 결과값 출력

		StringBuffer res = null;
		{ // 결과값 문자열로 바꿔놓기
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			res = new StringBuffer();
			while ((inputLine = br.readLine()) != null)
				res.append(inputLine);
		}

		java.util.Map<String, Object> returnParmeter = mapper.readValue(res.toString(),
				new TypeReference<java.util.Map<String, Object>>() {
				});

		return resultFun.apply(con.getResponseCode(), returnParmeter);

	}
}
