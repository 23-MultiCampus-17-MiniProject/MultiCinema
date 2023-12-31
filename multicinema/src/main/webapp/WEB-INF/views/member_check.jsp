<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>멀티시네마 가입여부 확인</title>


<link rel="stylesheet" type="text/css" href="resources/css/index.css">
</head>
<link rel="stylesheet" type="text/css" href="resources/css/join_confirm.css">
<script src="resources/js/member_check.js"></script>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	let message = "${result}";
	if(message != "" && message == "이미 존재하는 회원입니다"){
		alert(message);
		<%request.removeAttribute("result"); %>
	}else if(message != "" && message == "가입가능"){
		$("#user_id_check").attr("value", "${user_id}");
		$("#user_email_check").attr("value", "${user_email}");
		$("#check_form").attr("action","memberjoin").submit();
	}
	
});

</script>
</head>
<body>
<%@ include file="/WEB-INF/views/header/mainheader.jsp" %>
<div id="container">
	<div id="contents">
		<div id="contents_header">
			<h1>Multi Cinema 가입여부 확인</h1>
		</div>
		<div id="check">
			<div id="info">
				<P>회원 가입 여부 확인을 위해 개인정보를 정확히 입력해주세요<br>
					입력하신 정보는 가입 여부 확인에만 사용되며 저장되지 않습니다
				</P>
			</div>
			<div id="check_member_form">
				
				<div class="text_box">
					아이디 <input type="text" class="text" id="user_id" placeholder="아이디를 입력해주세요.">
					<p class="error_message" id="user_id_errmsg" style="visibility: hidden"></p>
				</div>
				<div class="text_box">
					이메일 <input type="text" class="text" id="user_email" placeholder="이메일을 입력해주세요" >
					@
					<select id="email_select">
						<option>naver.com</option>
						<option>google.com</option>
						<option>daum.net</option>
						<option>직접입력</option>
					</select>
					<input type="text" class="text" id="user_email_dir" placeholder="도메인을 입력해주세요" style="visibility: hidden" >
					<p class="error_message" id="user_email_errmsg" style="visibility: hidden"></p>
					
				</div>
				<div id="btn_confirm_wrap">
				<form id="check_form" action="membercheck" method="post">
					<input type="hidden" name="user_id" id="user_id_check" value="default">
					<input type="hidden" name="user_email" id="user_email_check" value="default">
					<input type="submit" id="btn_confirm" value="가입여부 확인" >
				</form>
				</div>
				
			</div>
		</div>
	</div> 
</div>
</body>
</html>