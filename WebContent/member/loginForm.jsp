<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<jsp:include page="../show/main.jsp" />
	<hr>
	<jsp:include page="sub/login.jsp" />

	<a id="kakao-login-btn"></a>
	<a href="http://developers.kakao.com/logout"></a>
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type='text/javascript'>
		//<![CDATA[
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		Kakao.init('d6e5cf48ae116f09fd297be33a5bc535');
		// 카카오 로그인 버튼을 생성합니다.
		Kakao.Auth.createLoginButton({
			container : '#kakao-login-btn',
			success : function(authObj) {
				alert(JSON.stringify(authObj));
				console.dir(authObj);
				
				$.ajax({
					type : "post",
					url : "/teamSquirrel/Oauth",
					data : authObj,
					datatype : "json",
					success : function(data){
						 var tesdt = JSON.parse(data);
						alert(data['test']);
						console.dir(tesdt);
					}
				});
			},
			fail : function(err) {
				alert(JSON.stringify(err));
			}
		});
		//]]>
	</script>

</body>
</html>