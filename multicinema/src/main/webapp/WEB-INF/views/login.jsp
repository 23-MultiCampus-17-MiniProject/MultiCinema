<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/index.css">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	let message = "${result}";
	if(message != ""){
		alert(message);
	}
});
</script>
<body>
<div id="headerInput"><a href="/multicinema/"><img src="resources/images/multiCinema_logo.png"></a></div>
<!-- body start -->

<div id="container">
	<div id="contents">
		<div id="contents_header">
		</div>
		<div id="login_box">
		<form action="login" method="post">
			<div class="user_login_wrap">
				<input name="user_id" id="user_login_id" type="text" placeholder="아이디를 입력해주세요">
			</div>
			<div class="user_login_wrap">
				<input name="user_pw" id="user_login_pw" type="password" placeholder="비밀번호를 입력해주세요">
			</div>
			<div id="login_btn_wrap">
				<input type="submit" id="login_btn" value="로그인">
			</div>
			<div id="sign_in_btn_wrap">
				<a id="sign_in_btn" href="membercheck"><span>회원가입</span></a>
			</div>
		</form>
		</div>
	</div>
</div>

<!-- body end -->
<div id="footerInput"></div>
</body>

</html>