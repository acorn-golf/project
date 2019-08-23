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

import com.squirrel.dto.GolfCcDTO;
import com.squirrel.dto.MemberDTO;
import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.ProductListDTO;
import com.squirrel.service.GolfccService;
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
			String currPage = request.getParameter("curPage");

			if(currPage == null) {
				currPage = "1";
			}
			int curPage = Integer.parseInt(currPage);
			int perPage = 10;
			int start = perPage * ((curPage)-1)+1;
			int end = perPage-1 + start;
			int totalRecord = 0;
			
			List<MemberDTO> list;
			List<ProductListDTO> pList;
			List<GolfCcDTO> gList;
			
			HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("start", start);
				map.put("end", end);
			
			ProductService pService;
			GolfccService gService;
			switch (adminSelect) {
			case "product":	
				pService = new ProductService();
				String product = request.getParameter("product");
				map.put("adminSearch", adminSearch);
				map.put("product", product);
				pList = pService.adminProductSelect(map);
				totalRecord = pService.totalRecord();
				request.setAttribute("pList",pList);
				break;
				
			case "ccinfo":
				gService = new GolfccService();
				String ccinfo = request.getParameter("ccinfo");
				map.put("adminSearch", adminSearch);
				map.put("ccinfo", ccinfo);
				gList = gService.adminGolfSelect(map);
				totalRecord = gService.totalRecord();
				request.setAttribute("gList",gList);
				System.out.println(totalRecord);
				break;
			

			default:
				String member = request.getParameter("member");
				map.put("adminSearch",adminSearch);
				map.put("member",member);
				list = mService.adminMemberSelect(map);	
				totalRecord = mService.totalRecord();
				request.setAttribute("list", list);
				break;
			}
			
			int endPage = totalRecord / perPage;
			if(totalRecord % perPage != 0) {
				endPage++;
			}
			
			int showPage = 10;
			int startPage = (curPage-1) / showPage * showPage + 1;
			int lastPage = startPage + showPage - 1;
			if (curPage == endPage || endPage < startPage + showPage) {
				lastPage = endPage;
			} else if (curPage < endPage) {
				lastPage = (startPage + showPage)-1;
			}
			
			int beforeShow = curPage - showPage;
				if(beforeShow < 1) beforeShow = 1; //0 또는 음수값이 될 경우
			int afterShow = beforeShow + showPage;
				if(afterShow>totalRecord) afterShow=totalRecord; // 총개시물을 초과할 경우
			
			request.setAttribute("adminSelect", adminSelect);
			request.setAttribute("adminSearch", adminSearch);			
			request.setAttribute("curPage", curPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("showPage", showPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("beforeShow", beforeShow);
			request.setAttribute("afterShow", afterShow);
			
			destination = "member/adminPageResult.jsp";
			
			session.setAttribute("login", dto);
			request.getRequestDispatcher(destination).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
