<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
	<link rel="stylesheet" href="./css/index.css">
    <style>
        #title{
            text-align:center;
            margin-top:15%;
        }
        #button{
            text-align:center;
        }
        #button>a{
            display:inline-block;
            text-decoration:none;
            font-size:20px;
            padding:20px;
            margin:0px 10px;
            border-radius:10px;
            background-color:aqua;
            color:black;
        }
        #button>a:hover{
            background-color:gray;
            color:white;
        }
    </style>
</head>
<body>
<!-- 공통 UI 삽입 부분 -->
<header class="body">
	<div class="header">
		<h1 class="mainlogo">
			<a href="mainpage.html" title="홈화면으로 가기">홈으로가기</a>
		</h1>
		<div class="myinformation">
			<a href="main_signout.html">로그아웃하기</a>
			<a href="mypage.html">내정보확인</a>
		</div>
	</div>
		
	<hr>
		<ul id="mainNavigator">
			<li id="movie"><a href="movie.html">영화</a></li>
			<li id="ticketing"><a href="timetable_select.html">예매</a></li>
			<li id="theater"><a href="theater.html">영화관</a></li>
		</ul>
	<hr>
</header>

<!-- 기능별 구현 부분 -->
<!-- 상영 시간표 기준을 선택 -->
<h3 id="title">상영 시간표를 어떻게 보시겠습니까?</h3>
<div id="button">
    <a href="timetable_date.html">날짜 기준으로 확인</a>
    <a href="timetable_movie.html">영화 기준으로 확인</a>
</div>
</body>
</html>