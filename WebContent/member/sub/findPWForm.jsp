<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var phoneid='';
		var email='';
		var email_chk='';
		$("#phoneid").on("keyup",function(){
			$.ajax({
				type : "post",
				url : "../PhoneIdCheckServlet",
				data :{
					phoneid:$("#phoneid").val()
				},
				dataType : "json",
				success : function(data,status,xhr){
					phoneid = data.phoneid;
					email = data.email;
					email_chk = data.email_chk;
					console.log(phoneid+email+email_chk);
					if(phoneid=='정보없음'){
						$("#idchk").text(data.phoneid);
					}
					
					$("#emailchk").val(data.email);
					$("#emailchkYN").val(data.email_chk);
				},
				error : function(xhr,status,error){
					console.log(error);
					console.log(status);
				}
			});
		});
		console.log(phoneid+email+email_chk);
		$("#find").on("click",function(event){
			event.preventDefault();
			if(phoneid == '정보없음' || $("#phoneid").val().length == 0){
				alert('아이디를 확인하세요');
			}
			if(email == '정보없음' || $("#email").val().length == 0){
				alert('이메일을 확인하세요');
			}
			if(email_chk == 'N'){
				alert('인증되지 않은 이메일입니다.');
			}
			if(email_chk == '정보없음'){
				alert('정보가 없는 이메일입니다')
			}
		});
	});
	
		
		
</script>

<form action="../SendPWMailServlet" method="get">
<table>
<tr>
<th> 아이디: </th>
<td><input type="text" class="login" id="phoneid" name="phoneid" placeholder="핸드폰번호 일껄요?" maxlength="11"><span id="idchk"></span>
</td>
</tr>
<tr>
<th> 이메일: </th>
<td><input type="email" class="login" id="email" name="email"></td>
</tr>
<tr>
<td colspan="2" align="right"><input type="submit" value="찾기" id="find" style="width: 50px"></td>
</tr>
</table>
</form>