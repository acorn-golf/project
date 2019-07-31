
package com.squirrel.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;

/**
 * Servlet Filter implementation class LoginChkFilter
 */

public class LoginChkFilter implements Filter {

	private List<String> anonymousUrl = new ArrayList<String>();

	/**
	 * Default constructor.
	 */
	public LoginChkFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hres = (HttpServletResponse) response;

		HttpSession session = hreq.getSession();
		

		if (anonymousUrl.contains(hreq.getServletPath()))
			chain.doFilter(request, response);
		else {
			MemberDTO dto = (MemberDTO) (session.getAttribute("login"));

			if (dto == null) {
				System.out.println("걸림"+hreq.getServletPath());
				session.setAttribute("amesg", "로그인이 필요한 작업입니다.");
				hres.sendRedirect("/teamSquirrel/LoginUIServlet");
			}else
				chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		String tmp = fConfig.getInitParameter("anonymousUrl");
		StringTokenizer tokenizer = new StringTokenizer(tmp,",\n");
		
		 while(tokenizer.hasMoreElements())
		 {
			 anonymousUrl.add(tokenizer.nextToken());
		 }
		 
		 for (String string : anonymousUrl) {
			System.out.println(string);
		}
				 
	}

}
