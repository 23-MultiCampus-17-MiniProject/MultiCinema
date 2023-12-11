<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>환영합니다</title>
<link rel="stylesheet" type="text/css" href="resources/css/index.css">
</head>
<header class="body">
	<div class="header">
		<h1 class="mainlogo">
			<a href="main_signout.html" title="홈화면으로 가기">홈으로가기</a>
		</h1>
		<div class="myinformation">
			<a href="main_signin.html">로그인하기</a>
			<a href="signin.html">회원가입</a>
		</div>
	</div>
		
	<hr>
	<ul id="mainNavigator">
		<li id="movie"><a href="movie.html">영화</a></li>
		<li id="ticketing"><a href="tiketing.html">예매</a></li>
		<li id="theater"><a href="theater.html">영화관</a></li>
	</ul>
	<hr>
</header>
<style>
	#welcome_phrase{
		text-align: center;
	}
	#main_page_btn{
		text-decoration: none;
		color: black;
		width: 180px;
		height: 50px;
		background-color: rgb(254, 228, 1);
		border: 10px solid rgb(254, 228, 1);
		display: block;
		margin:0 auto;
		line-height: 50px;
		text-align: center;
		border-radius: 3px;
	}
</style>
<script>
	onload=()=>{
		let name = "${user_name}";
		let welcome_greetings = document.getElementById("welcome_phrase");

		welcome_greetings.innerHTML = name + "님<br><br> MultiCinema의 회원이 되신걸 진심으로 환영합니다";
		
	}
	
	
</script>
<body>
	<h1 id="welcome_phrase"></h1>
	<a id = "main_page_btn" href="/multicinema/login">로그인 하기</a>
</body>
</html>