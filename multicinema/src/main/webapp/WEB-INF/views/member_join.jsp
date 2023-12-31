<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>멀티시네마 회원가입 페이지</title>
<link rel="stylesheet" type="text/css" href="resources/css/index.css">
</head>
<link rel="stylesheet" type="text/css" href="resources/css/member_join.css">
<script src="resources/js/member_join_1.js"></script>
<script src="resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/header/mainheader.jsp" %>
	<div id="container">
		<div id="contents">
			<div id="contents_header">
			<h1>Multi Cinema 회원가입</h1>
			</div>
			<table>
				<form action="welcome" method="post">
				<tr>
					<th>이름</th>
					<td>
						<input type="text" class="text" id="user_name" name="user_name" placeholder="성함을 입력해주세요.">
						<p style="visibility: hidden" id="user_name_errmsg"></p>
					</td>
	
				</tr>
				<tr>
					<th>생년월일</th>
					<td>
						<input type="date" id="user_birth" name="user_birthday">
						<p style="visibility: hidden" id="user_birth_errmsg"></p>
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="user_id" value="${user_id }" name="user_id" readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" id="user_pw" name="user_pw" placeholder="특수문자 2개 이상을 포함한 8~16자의 비밀번호를 입력해주세요" maxlength="16">
						<p style="color: black">사용가능한 특수문자 ~ ! @ # $ % ^ * + = - ? _</p>
						<p id="user_pw_onCaps" style="visibility: hidden"></p>
						<p id="user_pw_errmsg" style="visibility: hidden"></p>
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>
						<input type="password" id="user_pw_check">
						<p style="visibility: hidden" id="user_pw_check_errmsg"></p>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" id="user_email" value="${user_email }" name="user_email" readonly></td>
				</tr>
			</table>
	
			<div id="btn_join_wrap">
				<button id="btn_join">회원가입</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>
