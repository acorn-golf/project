<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#repassword").on("keyup",function(){
			console.log($("#password"),$("#repassword"));
			if($("#password").val()==($("#repassword").val())){
				$("#confirm").text("비밀번호 일치");
			}else{
			$("#confirm").text("비밀번호가 일치하지 않습니다.");
			};
		});
		
	});
		


</script>
<style>

</style>
<form action="MemberAddServlet" method="get">
<input type="hidden" id="rating" name="rating">
<input type="hidden" id="rstartdate" name="rstartdate">
<input type="hidden" id="renddate" name="renddate">
<input type="hidden" id="email_check" name="email_check">
<table>
<tr>
<th>아이디:</th>
<td><input class="inputmadd" type="text" id="phoneid" name="phoneid" placeholder="휴대전화 번호를 입력하세요 -생략"></td>
</tr>
<tr>
<th>비밀번호:</th>
<td><input class="inputmadd" type="password" id="password" name="password"></td>
</tr>
<tr>
<th>비밀번호확인:</th>
<td><input class="inputmadd" type="password" id="repassword" name="repassword"><span id="confirm"></span></td>
</tr>
<tr>
<th>이름 test:</th>
<td><input class="inputmadd" type="text" id="username" name="username"></td>
</tr>
<tr>
<th>별명:</th>
<td><input class="inputmadd" type="text" id="nickname" name="nickname" placeholder="앱 이용시 사용하실 이름"></td>
</tr>
<tr>
<th>생년월일:</th>
<td><input class="inputmadd" type="text" id="userssn" name="userssn" placeholder="20190101"></td>
</tr>
<tr>
<th style="text-align: right">남<input type="radio" id="male" value="male" name="gender" checked></th>
<th style="text-align: left">여<input type="radio" id="female" value="female" name="gender"></th>
</tr>
<tr>
<th>e-mail:</th>
<td><input class="inputmadd" style="width:80px" type="text" id="emailid" name="emailid" placeholder="인증시 필요">
@ <input style="width:80px" type="text" id="emailadd" name="emailadd" placeholder="직접 입력">
<select id="S_emailadd" name="S_emailadd">
<option>naver.com</option>
<option>hotmail.com</option>
<option>hanmail.net</option>
<option>gmail.com</option>
</select></td>
</tr>
<tr>
<td colspan="2" style="height:30px"></td>
</tr>
<tr>
<td colspan="2" style="text-align: center"><input type="submit" value="가입하기"><input type="reset" value="다시 작성"></td>
</tr>
</table>
</form>