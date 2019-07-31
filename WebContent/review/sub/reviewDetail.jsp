<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- ${user_no eq sessionScope.login.user_no} --%>
<c:choose>
	<c:when test="${user_no == 3}"> <%-- 3이아니라 로그인 세션의 유저pk로 비교해야함  --%>
		
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${nickname}</td>
				<th>평점</th>
				<td><select name="score">
					<c:forEach var="i" begin="0" end="5" step="1">
						<c:choose>
							<c:when test="${reviewdetail.score eq i}">
								<option selected="selected">${reviewdetail.score}</option>
							</c:when>
							<c:when test="${reviewdetail.score != i}">
								<option>${i}</option>
							</c:when>
						</c:choose>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${reviewdetail.score_date}</td>
				<th>조회수</th>
				<td>${reviewdetail.rv_vcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="rv_title" value="${reviewdetail.rv_title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea name="rv_content">${reviewdetail.rv_content}</textarea></td>
			</tr>
		</table>
		
	</c:when>
	<c:when test="${user_no != 3}"> <%-- 3이아니라 로그인 세션의 유저pk로 비교해야함  --%>
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
	</c:when>
</c:choose>
