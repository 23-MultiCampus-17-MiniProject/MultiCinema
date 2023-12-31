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
<%@ include file="/WEB-INF/views/header/mainheader.jsp" %>

<!-- 기능별 구현 부분 -->
<!-- 상영 시간표 기준을 선택 -->
<h3 id="title">상영 시간표를 어떻게 보시겠습니까?</h3>
<div id="button">
    <a href="timetable_date.html">날짜 기준으로 확인</a>
    <a href="timetable_movie.html">영화 기준으로 확인</a>
</div>
</body>
</html>