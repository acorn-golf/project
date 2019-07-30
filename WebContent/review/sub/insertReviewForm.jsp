<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="/teamSquirrel/jquery-3.4.1.js"></script> 
<script>
	$(document).ready(function(){
		$("#cancle").on("click",function(){
			$("form").attr("action","../ReviewListServlet"); // 아마 골프장 자세히보기로 가야되지 싶다
		});
	});
</script>
<form action="InsertReviewServlet" method="get" name="insertReviewForm">
<input type="hidden" name="cc_id" value="${cc_id}">
	<table>
		<tr>
			<th>평점</th>
			<td><select name="score">
				<option>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select></td>
		</tr>
		<tr>
			<th>후기 제목</th>
			<td><input type="text" name="rv_title" id="rv_title"></td>
		</tr>
		<tr>
			<th>후기 내용</th>
			<td><textarea rows="20" cols="30" name="rv_content" id="rv_content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><button id="cancle">취소</button>&nbsp;
			<input type="submit" value="등록"></td>
		</tr>
	</table>
</form>