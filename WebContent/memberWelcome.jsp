<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="show/main.jsp" %>
<hr>
<h1>#{dto.nickname}님 가입을 축하드립니다.</h1>
<form action="main.jsp">
<input type="submit" value="확인">
</form>
</body>
</html>