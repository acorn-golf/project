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
		
		$("#insert").on("click",function(){
			$.ajax({
				type:"post",
				url:"InsertCommentServlet",
				data:{
					score_no:$("#score_no").val(),
					user_no:$("#user_no").val(),
					re_content:$("#re_content").val()
				},
				dataType:"text",
				success:function(data,status,xhr){
					alert(data);
					$("#re_content").val("");
				},
				error:function(xhr,status,error){
					console.log(error);
					console.log(status);
				}
			});
			/* $.ajax({
				type:"post",
				url:"ReCommentViewServlet",
				data:{
					score_no:$("#score_no").val(),
					user_no:$("#user_no").val(),
				},
				dataType:"text",
				success:function(data,status,xhr){
					$("")
				},
				error:function(xhr,status,error){
					console.log(error);
					console.log(status);
				}
			}); */
		});
	});
</script>

<%-- ${user_no eq sessionScope.login.user_no} --%>
<form>
<input type="hidden" name="score_no" value="${reviewdetail.score_no}" id="score_no">
<input type="hidden" name="user_no" value="${login.user_no}" id="user_no">
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
<br><br>
</form>
<!-- 댓글등록 -->
<table>
		<tr>
			<td>댓글<textarea name="re_content" cols="30" rows="2" id="re_content"></textarea><button id="insert">등록</button></td>
		</tr>
</table>
<!-- 댓글보기 -->
<table>
		<tr id="header">
			<th>작성일</th>
			<th>작성내용</th>
			<th>작성자</th>
		</tr>
		
</table>
