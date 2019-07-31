<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

var idchk = true;
var nickchk = true;

	$(document).ready(function(){
		
		var RegexEmailId = /\w/; 
		var RegexEmailAdd = /\w+\.[a-zA-Z\.]{2,5}$/; 
		var RegexName = /^[가-힣]{2,4}$/; 
		var RegexNick = /^[a-zA-Z0-9가-힣_-]{2,16}$/; 
		var RegexPhone = /^(010|011|016|017|018|019|070)[0-9]{8}$/;
		var RegexPassword = /[a-zA-Z0-9\!\@\#\$\%\^\&\*\(\)\<\>\?\.]{7,20}/;
		var RegexBirth = /^(19|20)[0-9]{2}[01][0-9][0-3][0-9]/;
		
		$("input:text, input:password").keydown(function(event){
			if(event.keyCode === 13){
				event.preventDefault();
			}
		});
		
		$("form").on("submit",function(event){			

				if ( $("#phoneid").val() == ""){		
					
					alert("아이디를 입력해주세요.");
					$("#phoneid").focus();
					return false;
					
				}else if( !RegexPhone.test($.trim($("#phoneid").val())) ){
					
					alert("아이디 형식이 잘못되었습니다.");					
					$("#phoneid").val("");
					$("#phoneid").focus();
					return false;
					
				}else if ($("#password").val() == ""){	
					
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
					
				}else if ( !RegexPassword.test($.trim($("#password").val())) ){
					alert("비밀번호 오류");
					$("#password").val("");
					$("#password").focus();
					return false;
					
				}else if ( $("#repassword").val() == ""){
					
					alert("비밀번호 확인하셔야합니다.");
					$("#repassword").focus();
					return false;
					
					
				}else if ( $("#username").val() == ""){
					
					alert("이름을 입력해주세요.");
					$("#username").focus();
					return false;
					
				}else if ( !RegexName.test($.trim($("#username").val())) ){
					
					alert("이름 오류");
					$("#username").focus();
					return false;
					
				}else if ( $("#nickname").val() == ""){
					
					alert("별명을 입력해주세요.");
					$("#nickname").focus();
					return false;

				}else if ( !RegexNick.test($.trim($("#nickname").val())) ){

					alert("별명 오류");
					$("#nickname").focus();
					return false;
				}else if ( $("#userssn").val() == ""){
					
					alert("생년월일을 입력해주세요.")
					$("#userssn").focus();
					return false;
					
				}else if ( !RegexBirth.test($.trim($("#userssn").val())) ){
					
					alert("생년월일 오류");					
					$("#userssn").val("");
					$("#userssn").focus();
					return false;					
					
				}else if ( $("#emailid").val() == ""){
					
					alert("Email을 입력해주세요.");
					$("#emailid").focus();
					return false;

				}else if ( !RegexEmailId.test($.trim($("#emailid").val())) ){
					
					alert("Email 오류");					
					$("#emailid").val("");
					$("#emailid").focus();
					return false;
				
				}else if ( $("#emailadd").val() == ""){
					
					alert("Email을 입력해주세요.");
					$("#emailadd").focus();
					return false;

				}else if ( !RegexEmailAdd.test($.trim($("#emailadd").val())) ){
					
					alert("Email 오류");					
					$("#emailadd").val("");
					$("#emailadd").focus();
					return false;
				}
					this.action="/teamSquirrel/MemberAddServlet";
							 
		});
		
		$("#repassword").on("keyup",function(){
			if($("#password").val()==($("#repassword").val())){				
				$("#confirm").text("비밀번호 일치").css("color","green");
			}else{
				$("#confirm").text("비밀번호 불일치").css("color","red");
			};
		});		
		
		$("#phoneid").on("keyup",function(){
			$.ajax({
				type:"post",
				url:"IdCheckServlet",
				data: { phoneid : $("#phoneid").val()},				
				dataType:"text",
				success : function(data,status,xhr){	
					if(data == 0){
						$("#idcheck").text("사용 가능").css("color","green");
						idchk = true;
					}else{
						idchk = false;
						$("#idcheck").text("사용 불가").css("color","red");
							$("form").on("submit",function(event){							
								if(!idchk){
									alert("아이디가 중복입니다.");
									event.preventDefault();
									$("#phoneid").val("");
									$("#phoneid").focus();
									$("#idcheck").text("<--");
								}					
							});
						}					
					},
				error : function(xhr,status,error){
					console.log(xhr);
					console.log(status);
					console.log(error);					
				}										
			});				
		});		

		$("#nickname").on("keyup",function(event){
			$.ajax({
				type:"post",
				url:"IdCheckServlet",
				data: {nickname : $("#nickname").val()},
				dataType:"text",
				success : function(data,status,xhr){	
					if(data == 0){
						$("#nickcheck").text("사용 가능").css("color","green");
						nickchk=true;
					}else{
						nickchk=false;
						$("#nickcheck").text("사용 불가").css("color","red");
							$("form").on("submit",function(event){
								if(!nickchk){									
									event.preventDefault();
									alert("별명이 중복입니다.");
									$("#nickname").val("");
									$("#nickname").focus();
									$("#nickcheck").text("<--");
								}							
							});
						}					
					},
				error : function(xhr,status,error){
					console.log(xhr);
					console.log(status);
					console.log(error);
				}										
			});				
		});	
		
		$("#S_emailadd").on("focus change",function(){
			$("#emailadd").val($("#S_emailadd").val());
			$(this).html(`<option>다시 선택</option>
			<option>naver.com</option>
			<option>hotmail.com</option>
			<option>daum.net</option>
			<option>hanmail.co.kr</option>
			<option>gmail.com</option>`);
		});	

	});

</script>
<style>

</style>
<form method="post">
<input type="hidden" id="rating" name="rating" value="U">
<table>
<tr>
<th>아이디:</th>
<td><input class="inputmadd" type="text" id="phoneid" name="phoneid" placeholder="핸드폰 번호를 입력하세요 -생략"><span id="idcheck"></span></td>
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
<th>이름:</th>
<td><input class="inputmadd" type="text" id="username" name="username"></td>
</tr>
<tr>
<th>별명:</th>
<td><input class="inputmadd" type="text" id="nickname" name="nickname" placeholder="앱 이용시 사용하실 이름"><span id="nickcheck"></span></td>
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
@ <input class="inputmadd" style="width:80px" type="text" id="emailadd" name="emailadd" placeholder="직접 입력">
<select id="S_emailadd" name="S_emailadd">
<option>naver.com</option>
<option>hotmail.com</option>
<option>daum.net</option>
<option>hanmail.co.kr</option>
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