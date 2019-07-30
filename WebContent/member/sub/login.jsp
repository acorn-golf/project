0<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("form").on("click",function(event){
			
			if($("#phoneid").val()==""&&$("#password").val()==""){
				event.preventDefault();
			}else{
				this.action="/teamSquirrel/LoginServlet";
			}
		});
		
	});
</script>
<form method="post">
<table>
<tr>
<th>아이디:</th>
<td><input type="text" class="login" id="phoneid" name="phoneid" placeholder="핸드폰번호 일껄요?"></td>
</tr>
<tr>
<th>비밀번호:</th>
<td><input type="password" class="login" id="password" name="password"></td>
</tr>
<tr>
<td colspan="2" style="text-align: center">
<input type="submit" value="로그인">
<input type="reset" value="다시입력"></td>
</tr>
</table>
</form>