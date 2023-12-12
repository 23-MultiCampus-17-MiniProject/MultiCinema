<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>마이 페이지</title>


<link rel="stylesheet" type="text/css" href="resources/css/index.css">
<link rel="stylesheet" type="text/css" href="resources/css/mypageCSS.css">
<style>

</style>
</head>
<body >
<%@ include file="/WEB-INF/views/header/mainheader.jsp" %>
	
	<script type = "module" src ="resources/script/mypage.js"></script>
	
	<script type = "module" src ="/multicinema/resources/script/mypage.js"></script>
<div id = "myPage_navigater" >
	<div id="reserve_detail"> 예매내역</div><hr >
	<div id="info_change"> 회원 정보 수정</div><hr >
	<div id="my_review"> 작성 리뷰 게시글</div><hr >
</div>

<div id = "myPage_main" > 
회원 정보 변경이 완료 되었습니다 <br>
<a href="/multicinema/"> 홈으로 가기</a>
</div>



</body>
</html>