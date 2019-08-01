<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<table border="1" class="form_main">
<c:forEach var="member" items="${list}">
<tr>
<td>${member.phone_id}</td>
<td>${member.userpw}</td>
<td>${member.username}</td>
<td>${member.nickname}</td>
<td>${member.gender}</td>
<td>${member.rating}</td>
<td>${member.rstartdate}</td>
<td>${member.renddate}</td>
<td>${member.email}</td>
<td>${member.email_chk}</td>
<tr>
</c:forEach>
</table>