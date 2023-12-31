onload = function(){
	
	let movie_title = document.getElementsByClassName("movie_title");
	let movie_btn = document.querySelectorAll(".movie_btn a");
	let movie_detail = document.getElementsByClassName("movie_detail");
	
	
	let movie_info_score = document.getElementsByClassName("movie_info_score");
	
	let movieList = document.getElementById("movieList");
	
	function add_event(){
		
		let movie_poster_frame = document.querySelectorAll(".movie > .img_wrap > img");
		let movie_grade_frame = document.querySelectorAll(".movie > .img_wrap > .age_limit_icon > img");
		let movie_detail_wrap = document.getElementsByClassName("movie_detail_wrap");
		let movie_detail_btn = document.getElementsByClassName("movie_detail_btn");
		for(let i =0; i < movie_poster_frame.length; i++){
			movie_poster_frame[i].addEventListener("mouseenter", ()=>{
				movie_detail_wrap[i].style = "visibility: visible";
			})
			movie_detail_wrap[i].addEventListener("mouseleave", e =>{
				e.target.style = "visibility: hidden";
			})
		
			movie_detail_btn[i].addEventListener("mouseenter", e =>{
				e.target.style = "background-color: rgb(254, 228, 1)"
			})
			movie_detail_btn[i].addEventListener("mouseleave", e =>{
				e.target.style = "background-color: white"
			})
		}
	}
	
	
	function Movie(movieCd, movieNm, grade, rank){
		
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.rank = rank;
		this.grade = grade;
		
	}
	
	console.log("테스트")
	let btn_left = document.getElementById("slide_btn_left");
	let btn_right = document.getElementById("slide_btn_right");
	var current_page = 1;
	
	
	var end_page = Math.ceil(10 / 5);
	
	btn_right.addEventListener('click', function(){
		if(end_page != current_page){
			document.getElementById("movieList").style.transform = "translate(-" + (1428 * current_page) + "px)"
			document.getElementById("movieList").style.transitionProperty = "transition-property: transform;";
			document.getElementById("movieList").style.transitionDuration = "0.5s";
			current_page++;
			console.log(current_page);
			console.log("endpage:" +end_page);
		}
	});
	btn_left.addEventListener('click', function(){
		if(current_page != 1){
			current_page--;
			document.getElementById("movieList").style.transform = "translate(-" + (1428 * (current_page - 1))+ "px)"
			document.getElementById("movieList").style.transitionProperty = "transition-property: transform;";
			document.getElementById("movieList").style.transitionDuration = "0.5s";
			console.log(current_page);
			
		}
	});
	
	add_event();
}