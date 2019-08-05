<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">

	$(document).ready(function(){		

		$("#adminSelect, #adminSearch").on("click",function(){
			if( $("select").val() == "member" ){				
				$("#memberSelect").html(`
				<td style="width: 80px;">아이디<input type="radio" id="memberId" name="member" value="phone_id"></td>
				<td style="width: 80px;">이름<input type="radio" id="memberName" name="member" value="username"></td>
				<td style="width: 80px;">닉네임<input type="radio" id="memberNick" name="member" value="nickname"></td>`);
			}else if( $("select").val() == "product" ){
				$("#memberSelect").html(`
				<td style="width: 80px;">골프장<input type="radio" id="memberId" name="member" value="phone_id"></td>
				<td style="width: 80px;">날짜<input type="radio" id="memberName" name="member" value="username"></td>
				<td style="width: 80px;">가격<input type="radio" id="memberNick" name="member" value="nickname"></td>`);
			} 
		
		});
		$("#adminPage").on("click",function(){
			
			this.action="/teamSquirrel/AdminPageServlet";
		});
	});
</script>
<form id="adminPage" method="get">
<table border="1" class="form_main">
<tr>
<th>
<select style="size: 40px;" id="adminSelect" name="adminSelect">
<option value="member">회원</option>
<option value="product">상품</option>
<option value="location">지역</option>
<option value="ccname">골프장명</option>
<option value="notice">공지사항</option>
<option value="order">주문목록</option>
</select></th>
<td style="width: 280px;"><input type="text" id="adminSearch" name="adminSearch" placeholder="검색조건이 없으면 전체"></td>
<td><input type="submit" id="adminSubmit" value="검색"></td>
</tr>
</table>
<table class="form_main">
<tr id="memberSelect">
</tr>
</table>
</form>