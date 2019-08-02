<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<form class="form_main">
<table style="border: 1px; solid: 2px">
<c:forEach var="member" items="${list}">
<c:if test="${member.user_no}">
<tr>
<th>아이디</th>
<th>이름</th>
<th>닉네임</th>
<th>등급</th>
<th>e-mail</th>
</tr>
</c:if>
<tr>
<td>${member.phone_id}</td>
<td>${member.username}</td>
<td>${member.nickname}</td>
<td>${member.rating}</td>
<td>${member.email}</td>
</tr>
</c:forEach>
</table>
</form>