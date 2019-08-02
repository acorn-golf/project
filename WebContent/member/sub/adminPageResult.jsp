<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<form class="form_main">
<table class="line_table">
<c:forEach var="member" begin="0" items="${list}" varStatus="status">
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
<td class="line_td">${member.phone_id}</td>
<td class="line_td">${member.username}</td>
<td class="line_td">${member.nickname}</td>
<td class="text_center line_td">${member.rating}</td>
<td class="line_td">${member.email}</td>
</tr>
</c:forEach>
</table>
</form>