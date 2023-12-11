<%@page import="com.mc.multicinema.DailyBoxOfficeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>최고의 영화관. MultiCinema</title>
<link rel="stylesheet" type="text/css" href="resources/css/index.css">
</head>
<header class="body">
	<div class="header">
		<h1 class="mainlogo">
			<a href="main_signout.html" title="홈화면으로 가기">홈으로가기</a>
		</h1>
		<div class="myinformation">
			<a href="login.html">로그인하기</a>
			<a href="join_confirm.html">회원가입</a>
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
<link rel="stylesheet" type="text/css" href="resources/css/mainpage.css">
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script src="resources/js/mainpage2_1.js"></script>
<script>

</script>
</head>
<body>
${login_user_name }
<%
ArrayList<DailyBoxOfficeDTO> list = (ArrayList<DailyBoxOfficeDTO>)request.getAttribute("movielist");
double movieListWidth = Math.ceil(list.size()/5 )* 1428;
%>

		<div id="contents"><!--박스오피스 칸-->
			<div id="boxoffice">박스오피스
				
			</div>
			<div id ="slide_btn">
				<button id="slide_btn_left"> < </button><button id="slide_btn_right"> > </button>
			</div>
			<div id="movieChart">
				<div id="movieList" style="width:<%=movieListWidth %>px">
					<%for(DailyBoxOfficeDTO dto : list){ 
						String audiAcc_str = "";
						if(dto.getAudiAcc()>=10000){
							audiAcc_str = dto.getAudiAcc()/10000 +"만";
						}else{
							audiAcc_str = dto.getAudiAcc() + "";
						}
					%>
						<div class="movie">
							<div class = "img_wrap">
								<img src= "resources/images/movie_poster/<%=dto.getRank() %>.jpg" alt="${dto.rank}" >
								<div class="movie_detail_wrap" style="visibility: hidden">
									<a href="moviedetail?movie_cd=<%=dto.getMovieCd() %>" class="movie_detail" >
										<div class="movie_detail_btn">상세보기</div>
									</a>
								</div>
								<div class = "age_limit_icon">
									<img src="resources/images/age_grade/<%=dto.getGrade()%>.png">
								</div>
								<div class = "rank"><%=dto.getRank()%></div>
							</div>
							<div class = "movie_info">
								<div class="movie_title"><%=dto.getMovieNm()%></div>
								<span class="movie_info_score">평점 </span>
								<span> 누적관객수 <%=audiAcc_str  %>명</span>
							</div>
							<div class = "movie_btn">
								<div class = "ticket_btn"><a href=""> 예매하기 </a></div>
								<div class = "review_btn"><a href=""> 리뷰보기 </a></div>
							</div>
						</div>
					<%} %>	
				</div>
			</div>
		</div>
</body>
</html>