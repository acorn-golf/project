package com.squirrel.controller.Member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.service.MemberService;
import com.squirrel.service.ProductService;

@WebServlet("/AdminPageServlet")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String destination = null;
		if(dto == null) {
			destination = "LoginUIServlet";
			response.sendRedirect(destination);
		}else {
			
			String nickname = dto.getNickname();
			MemberService mService = new MemberService();			
			dto = mService.myPage(nickname);
			
			String adminSelect = request.getParameter("adminSelect");
			String adminSearch = request.getParameter("adminSearch");
			String member = request.getParameter("member");
			String product = request.getParameter("product");
			String currPage = request.getParameter("curPage");	
			
			if(currPage == null) {
				currPage = "1";
			}
			int curPage = Integer.parseInt(currPage);
			int perPage = 10;
			int start = perPage * ((curPage)-1)+1;
			int end = perPage-1 + start;
			int totalRecord = 0;
			
			List<MemberDTO> list = null;
			HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("start", start);
				map.put("end", end);
			
			ProductService pService;
			
			if( adminSelect.equals("member") ){					
				map.put("adminSearch",adminSearch);
				map.put("member",member);
				list = mService.adminMemberSelect(map);	
				totalRecord = mService.totalRecord();			
			}else if( adminSelect.equals("product") ){
				pService = new ProductService();
				map.put("adminSearch", adminSearch);
				map.put("product",product);
				/*
				 * list = pService.adminProductSelect(map); totalRecord =
				 * pService.totalRecord();
				 */
			}
			System.out.println(list.size());
			int endPage = totalRecord / perPage;
			if(totalRecord % perPage != 0) {
				endPage++;
			}
			int show = 10; 
			int minPage = ((curPage-1) / (show)) * show + 1;
			int maxPage = 0;
			
			if (list.size() < show) {
				maxPage = 0;
			}else if (curPage == endPage || endPage < minPage + show) {
				maxPage = endPage;
			} else if (curPage < endPage) {
				maxPage = minPage + show - 1;
			} 
			
			int perBlock = 0;//totalPage/showBlock; 
			if(endPage%show==0) { 
				perBlock = (endPage/show)-1; 
			}else { 
				perBlock = endPage/show;
		    }		 
			request.setAttribute("adminSelect", adminSelect);
			request.setAttribute("list", list);
			request.setAttribute("curPage", curPage);
			request.setAttribute("perBlock", perBlock);
			request.setAttribute("endPage", endPage);
			request.setAttribute("show", show);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("minPage", minPage);
			
			destination = "member/adminPageResult.jsp";
			
			session.setAttribute("login", dto);
			request.getRequestDispatcher(destination).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
