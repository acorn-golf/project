<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="/teamSquirrel/jquery-3.4.1.js"></script> 
<script>
	$(document).ready(function(){
		$("#insertReview").on("click",function(){
			$("form").attr({"action":"InsertReviewFormServlet","method":"post"});
		});
	});
</script>

<form name="ReviewListForm" action="ReviewListServlet" method="post">
<input type="hidden" name="cc_id" value="${cc_id}"> <!-- 후기글쓰기 할 때 갖고갈 파라미터 -->

<input type="radio" name="orderby" value="score_date">최신순&nbsp;&nbsp;
<input type="radio" name="orderby" value="score">평점순<br>
<table border="1"><!-- 검색기능 추가해야됨 -->
	<tr>
		<td colspan="5">
			<select name="searchName">
				<option value="rv_title">제목</option>
				<option value="nickname">작성자</option>
			</select>
			<input type="text" name="searchValue" size="40">
			<input type="submit" value="검색">
		</td>
	</tr>
	<tr>
		<th>골프장</th>
		<th>평점</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="dto" items="${reviewList}" varStatus="status" >
		<tr>
			<td>${dto.cc_name}</td>
			<td>${dto.score}</td>
			<td><a href="ReviewDetailServlet?score_no=${dto.score_no}&user_no=${dto.user_no}">${dto.rv_title}</a></td>
			<td>${dto.nickname}</td>
			<td>${dto.score_date}</td>
		</tr>
		
	</c:forEach>

<tr>
<td align="center" colspan="5">
<c:choose>
	<c:when test="${curPage eq 1}">
		◀
	</c:when>
	<c:when test="${curPage != 1}">
		<a href="ReviewListServlet?curPage=1">◀</a>
	</c:when>
</c:choose>&nbsp;&nbsp;
<c:forEach var="i" begin="1" end="${totalPage}" step="1">
	<c:choose>
		<c:when test="${curPage eq i}">
			${i}
		</c:when>
		<c:when test="${curPage != i}">
			<a href="ReviewListServlet?curPage=${i}">${i}</a>&nbsp;
		</c:when>
	</c:choose>	
</c:forEach>&nbsp;
<c:choose>
	<c:when test="${curPage eq totalPage}">
		▶
	</c:when>
	<c:when test="${curPage != totalPage}">
		<a href="ReviewListServlet?curPage=${totalPage}">▶</a>
	</c:when>
</c:choose>
</td>
</tr>
</table>
<button id="insertReview">글쓰기</button>
</form>
