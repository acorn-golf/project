<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${empty login}">
<a href="MemberUIServlet">회원 가입</a>
<a href="LoginUIServlet">로그인</a>
</c:if>
<c:if test="${login.rating=='U'}">
안녕하세요 ${login.nickname} 님<br>
<a href="MyPageServlet">My Page</a>
<a href="LogoutServlet">로그아웃</a>
</c:if>
<c:if test="${login.rating=='M'}">
안녕하세요 ${login.nickname} 님<br>
<a href="MyPageServlet">My Page</a>
<a href="LoginOutServlet">로그 아웃</a>
<a href="ProductServlet">상품 등록</a>
<a href="">상품 보기</a>
</c:if>
<c:if test="${login.rating=='A'}">
안녕하세요 ${login.nickname} 님<br>
<a href="MyPageServlet">Admin Page</a>
<a href="">Manager 관리</a>
<a href="LoginOutServlet">로그 아웃</a>
</c:if>