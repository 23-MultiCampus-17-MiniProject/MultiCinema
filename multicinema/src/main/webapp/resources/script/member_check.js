//아이디 입력
//아이디가 조건에 맞는지(글자수 8~15글자, 영어,숫자만)
//안맞으면 member_validating에 focus가 사라진 뒤 오류메세지를 띄우게
//이메일이 조건에 맞는지
//안맞으면 member_validating에 focus가 사라진 뒤 오류메세지를 띄우게
//가입여부 확인 눌렀을 때 중복확인 + 조건확인
//통과시 회원가입 페이지로
//그 외엔 오류 메세지 띄우기
	onload=function(){
		let user_id = document.getElementById("user_id");
		let user_email = document.getElementById("user_email");
		let user_id_errMsg = document.querySelector("#user_id_errmsg");
		let user_email_errMsg = document.querySelector("#user_email_errmsg");
		let email_select = document.getElementById("email_select");
		let user_email_dir=document.getElementById("user_email_dir");
		let btn_confirm = document.getElementById("btn_confirm");
		
		let user_id_reg = /^[A-Za-z0-9]{4,12}$/;;
		let user_email_reg = /^[A-Za-z0-9]{4,12}$/;
		let user_email_dir_reg = /^[A-Za-z0-9]{1,}.(co\.kr|com|net)$/
		let email_reg =/^[A-Za-z0-9]{4,12}@[A-Za-z0-9]{1,}.(co\.kr|com|net)$/
		
		let dummy = {
			userid: "testdummy",
			email: "testdummy@naver.com"
		}
		
		//아이디, 이메일 입력 후 focus 사라지면 error 숨겨져 있던 메세지 출력
		let email = "";
		
		user_id.onblur=function(){
			
			if(user_id_reg.test(user_id.value) == false){
				user_id_errMsg.setAttribute("style","visibility: visible");
				user_id_errMsg.innerHTML = "영어, 숫자 혼합 4~12글자 아이디만 입력하실 수 있습니다";
			}else{
				user_id_errMsg.setAttribute("style","visibility: hidden");
				user_id_errMsg.innerHTML = ""
				
			}
		}
		
		user_email.onfocus = function(){
			user_email_errMsg.innerHTML = "";
		}
		
		user_email.onblur = function(){
			let flg = true;
			if(user_email_reg.test(user_email.value) == false){
				user_email_errMsg.setAttribute("style","visibility: visible");
				user_email_errMsg.innerHTML += "입력 양식이 올바르지 않습니다<br>";
				flg = false;
				
			}
			if(user_email_dir_reg.test(user_email_dir.value) == false && email_select.value=="직접입력"){
				user_email_errMsg.setAttribute("style","visibility: visible");
				user_email_errMsg.innerHTML += "도메인 입력 양식이 올바르지 않습니다<br>";
				flg = false;
			}
			if(flg){
				user_email_errMsg.setAttribute("style","visibility: hidden");
				email = user_email.value + "@" + email_select.value;
				console.log(email);
			}
		}
		
		email_select.onchange = function () {

			if (email_select.value == "직접입력") {

				user_email_dir.setAttribute("style", "visibility: visible");

				user_email_dir.onfocus = function () {
					user_email_errMsg.innerHTML = "";
				}

				user_email_dir.onblur = function () {
					let flg = true;
					if (user_email_reg.test(user_email.value) == false) {
						user_email_errMsg.setAttribute("style", "visibility: visible");
						user_email_errMsg.innerHTML += "입력 양식이 올바르지 않습니다<br>";
						flg = false;

					}
					if (user_email_dir_reg.test(user_email_dir.value) == false && email_select.value == "직접입력") {
						user_email_errMsg.setAttribute("style", "visibility: visible");
						user_email_errMsg.innerHTML += "도메인 입력 양식이 올바르지 않습니다<br>";
						flg = false;
					}
					if (flg) {
						user_email_errMsg.setAttribute("style", "visibility: hidden");
						email = user_email.value + "@" + user_email_dir.value;
						console.log(email);
					}
				}
			}
			else {
				user_email_dir.setAttribute("style", "visibility: hidden");
				user_email_dir.value = "";
				email = user_email.value + "@" + email_select.value;
				console.log(email);
			}
		
		}//email_select.onchange end
		
		btn_confirm.onclick = function(e){
			let tmp = email_select.value == "직접입력"? user_email_dir.value : email_select.value
			let email = user_email.value + "@" + tmp;
			let id = user_id.value;
			document.getElementById("user_email_check").value = email;
			document.getElementById("user_id_check").value = id;
			
			if(!email_reg.test(email) || !user_id_reg.test(id)){
				e.preventDefault();
				alert("다시 입력해주세요");
			}else{

			}
		}
	}