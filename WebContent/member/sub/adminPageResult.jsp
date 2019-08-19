<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>

<form method="get" class="form_main">
<table class="line_table">
<c:if test="${adminSelect eq 'member'}">
<c:forEach var="member" items="${list}" varStatus="status">
<c:if test="${status.first}">
<tr>
<th class="line_th">아이디</th>
<th class="line_th">이름</th>
<th class="line_th">닉네임</th>
<th class="line_th">등급</th>
<th class="line_th">e-mail</th>
</tr>
</c:if>
<tr>
<td class="line_td" style="background-color: lightgreen">${member.phone_id}</td>
<td class="line_td" style="background-color: lightblue">${member.username}</td>
<td class="line_td"><a href="/teamSquirrel/AdminModifiedUIServlet?nickname=${member.nickname}">${member.nickname}</a></td>
<td class="text_center line_td">${member.rating}</td>
<td class="line_td">${member.email}</td>
</tr>
</c:forEach>
</c:if>
<tr>
<td colspan="4" class="text_center">
	<c:if test="${curPage != 1 || curPage != ''}">
				<a href="AdminPageServlet?adminSelect=${adminSelect}&curPage=1">◀◀</a>&nbsp;&nbsp;
				<c:if test="${curPage > show}"><a href="AdminPageServlet?adminSelect=${adminSelect}&curPage=${minPage-2}">◁</a>&nbsp;&nbsp;</c:if>			
			</c:if>	
		<c:forEach var="i" begin="${minPage}" end="${maxPage}" step="1">	
				<c:choose>
					<c:when test="${curPage eq i}">
						<span style="color:red">${i}</span>
					</c:when>
					<c:when test="${curPage != i}">
						<a href="AdminPageServlet?adminSelect=${adminSelect}&curPage=${i}">${i}</a>&nbsp;
					</c:when>
				</c:choose>	
		</c:forEach>
			<c:if test="${curPage != endPage}">				
				<c:if test="${curPage <= show * perBlock}"><a href="AdminPageServlet?adminSelect=${adminSelect}&curPage=${maxPage+1}">▷</a></c:if>
				&nbsp;&nbsp;<a href="AdminPageServlet?adminSelect=${adminSelect}&curPage=${endPage}">▶▶</a>
			</c:if>
</td>
</tr>
</table>
</form>