<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript" src="/teamSquirrel/jquery-3.4.1.js"></script> 
<script>
	$(document).ready(function(){
		$("#updateReviewDeatil").on("click",function(){
			$("form").attr({"action":"UpdateReviewformServlet","method":"post"});
		});
		$("#deleteReviewDeatil").on("click",function(){
			$("form").attr({"action":"DeleteReviewDeatilServlet","method":"post"});
		});
		$("#ReviewList").on("click",function(){
			location.href="ReviewListServlet";
		});
	});
</script>

<%-- ${user_no eq sessionScope.login.user_no} --%>
<form>
<input type="hidden" name="score_no" value="${reviewdetail.score_no}">

<table border="1">
			<tr>
				<th>작성자</th>
				<td>${nickname}</td>
				<th>평점</th>
				<td>${reviewdetail.score}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${reviewdetail.score_date}</td>
				<th>조회수</th>
				<td>${reviewdetail.rv_vcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${reviewdetail.rv_title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${reviewdetail.rv_content}</td>
			</tr>
</table>
<c:choose>
	<c:when test="${user_no eq login.user_no || login.rating eq 'A'}"> <%-- 3이아니라 로그인 세션의 유저pk로 비교해야함, 세션의 등급확인(관리자)  --%>
		<button id="updateReviewDeatil">수정</button>&nbsp;<button id="deleteReviewDeatil">삭제</button>
	</c:when>
</c:choose>
<input type="button" value="목록" id="ReviewList">
</form>