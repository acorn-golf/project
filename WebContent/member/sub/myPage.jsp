<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">

	
	$(document).ready(function(){
		
		$("#repassword").on("keyup",function(){
			if($("#password").val()==($("#repassword").val())){
				$("#font").attr("color","green");
				$("#confirm").text("비밀번호 일치");
			}else{
				$("#font").attr("color","red");
				$("#confirm").text("비밀번호 불일치");
			};
		});
		$("form").on("click",function(event){
			
			if($("#repassword").val()==""&&$("#password").val()==""){
				event.preventDefault();
			}else{
				this.action="/teamSquirrel/MyPageUpdateServlet";
			}
		});
		if(${login.gender}==1){
			$("#male").attr("checked","checked");
		}else{
			$("#female").attr("checked","checked");
		}
		$("[type='radio']").attr("disabled","true");
		
	});

</script>
<style>
#star{
	color:red;
}
</style>
<form method="post">
<input type="hidden" id="rating" name="rating" value="${login.rating}">
<input type="hidden" id="rstartdate" name="rstartdate" value="${login.rstartdate}">
<input type="hidden" id="renddate" name="renddate" value="${login.renddate}">
<input type="hidden" id="email_check" name="email_check" value="${login.email_chk}">
<input type="hidden" id="gender" name="gender" value="${login.gender}">
<table>
<tr>
<th><font id="star">*</font>아이디:</th>
<td><input class="myupdate" type="text" id="phoneid" name="phoneid" value="${login.phone_id}" readonly></td>
</tr>
<tr>
<th><font id="star">*</font>비밀번호:</th>
<td><input class="myupdate" type="password" id="password" name="password"></td>
</tr>
<tr>
<th><font id="star">*</font>비밀번호확인:</th>
<td><input class="myupdate" type="password" id="repassword" name="repassword"><font id="font"><span id="confirm"></span></font></td>
</tr>
<tr>
<th>이름:</th>
<td><input class="myupdate" type="text" id="username" name="username" value="${login.username}" readonly></td>
</tr>
<tr>
<th>별명:</th>
<td><input class="myupdate" type="text" id="nickname" name="nickname" value="${login.nickname}" readonly></td>
</tr>
<tr>
<th>생년월일:</th>
<td><input class="myupdate" type="text" id="userssn" name="userssn" value="${login.userssn}" readonly></td>
</tr>
<tr>
<th style="text-align: right">남<input type="radio" id="male" value="male" name="gender"></th>
<th style="text-align: left">여<input type="radio" id="female" value="female" name="gender"></th>
</tr>
<tr>
<th><font id="star">*</font>e-mail:</th>
<td><input class="myupdate" style="width:85px" type="text" id="emailid" name="emailid" value="${email[0]}">
@ <input style="width:85px" type="text" id="emailadd" name="emailadd" value="${email[1]}">
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
<td colspan="2" style="text-align: center"><input type="submit" value="수정 하기"><input type="reset" value="다시 작성"></td>
</tr>
</table>
</form>