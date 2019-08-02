<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">

	$(document).ready(function(){		

		$("select").on("change",function(){
			if( $(this).val() == "member" ){
				$("#memberSelect").html(`<td style="width: 80px;">전체<input type="radio" id="memberAll" name="member" value="memberAll"></td>
				<td style="width: 80px;">아이디<input type="radio" id="memberId" name="member" value="memberId"></td>
				<td style="width: 80px;">이름<input type="radio" id="memberName" name="member" value="memberName"></td>
				<td style="width: 80px;">닉네임<input type="radio" id="memberNick" name="member" value="memberNick"></td>
				<td style="width: 90px;">주민번호<input type="radio" id="memberSsn" name="member" value="memberSsn"></td>`);
			} 
		
		});
		$("form").on("click",function(){
			
			this.action="/teamSquirrel/AdminPageServlet";
		});
	});
</script>
<form method="get">
<table border="1" class="form_main">
<tr>
<th>
<select style="size: 40px;" id="adminSearchSelect" name="adminSearchSelect">
<option value="all">검색조건</option>
<option value="member">회원</option>
<option value="product">상품</option>
<option value="location">지역</option>
<option value="ccname">골프장명</option>
<option value="notice">공지사항</option>
<option value="order">주문목록</option>
</select></th>
<td style="width: 280px;"><input type="text" id="adminSearchContent" name="adminSearchContent"></td>
<td><input type="submit" id="adminSearchSubmit" value="검색"></td>
</tr>
</table>
<table class="form_main">
<tr id="memberSelect">
</tr>
</table>
</form>