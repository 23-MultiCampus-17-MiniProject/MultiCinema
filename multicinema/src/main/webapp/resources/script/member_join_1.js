	onload = function () {
		let user_id = document.getElementById("user_id");
		let user_email = document.getElementById("user_email");
		let user_pw = document.getElementById("user_pw");
		let user_pw_check = document.getElementById("user_pw_check");
		let user_birth = document.getElementById("user_birth");
		let user_birth_errmsg = document.getElementById("user_birth_errmsg");
		let user_pw_errmsg = document.getElementById("user_pw_errmsg");
		let user_pw_check_errmsg = document.getElementById("user_pw_check_errmsg");
		let user_name = document.getElementById("user_name");
		let user_name_errmsg = document.getElementById("user_name_errmsg");
		let user_pw_onCaps = document.getElementById("user_pw_onCaps");
		let btn_join = document.getElementById("btn_join");
	
		
		
		let user_data = {
			id: "",
			email: "",
			pw: "",
			name: "",
			birth: ""
		}
		
		
		//이름 양식: 완성된 한글 + 알파벳
		let user_name_reg = /^[가-힣a-zA-z]{1,}$/g;
		
		user_name.addEventListener("change", () => { //강사님께 여쭤보기 이름 입력후 다른 text를 누르면 false가 뜨는것
			if(user_name_reg.test(user_name.value) == false){
				user_name_errmsg.style = "visibility: visible";
				user_name_errmsg.innerHTML = "올바르지 않은 이름입니다";
			}else{
				user_name_errmsg.innerHTML = "";
				user_name_errmsg.style = "visibility: collapse";
			}
		});
		
		
		
		//생년월일: 오늘 날짜 이후를 선택하면 잘못된 날짜라고 알려주기
	
		user_birth.addEventListener("change", ()=>{
			
			if(new Date(user_birth.value) - Date.now() > 0){
				user_birth_errmsg.style = "visibility: visible";
				user_birth_errmsg.innerHTML = "올바르지 않은 날짜입니다"	;
			}else{
				user_birth_errmsg.style = "visibility: hidden";
				user_birth_errmsg.innerHTML = "";
			}
			
		});
		
		//비밀번호 양식: 몇자,특수문자 반드시,캡스락
		
		let user_pw_reg = /[~!@#$%^*+=-?_]{1}/g; //이 이외의 특수문자 걸러내기
		
		user_pw.addEventListener("focus",function(){
			user_pw_errmsg.innerHTML = "";
		});
		
		user_pw.addEventListener("change",function(){
			
			let flg = true;
			let spcl_num = user_pw.value.match(user_pw_reg) == null ? 0 : user_pw.value.match(user_pw_reg).length;
			if(spcl_num < 2){
				user_pw_errmsg.setAttribute("style", "visibility: visible");
				user_pw_errmsg.innerHTML += "특수문자를 반드시 2글자 이상 넣어야합니다<br>";
				flg = false;
			}
			if(user_pw.value.length < 8){
				user_pw_errmsg.setAttribute("style", "visibility: visible");
				user_pw_errmsg.innerHTML += "비밀번호를 최소 8자리 입력해주세요<br>";
				flg = false;
			}
			if(flg == true){
				user_pw_errmsg.setAttribute("style", "visibility: hidden");
				user_pw_errmsg.innerHTML = "";
			}
			
		});
		
		user_pw.addEventListener("blur", function(){
			if(user_pw_errmsg.innerHTML == ""){
			
				let flg = true;
				let spcl_char_num = user_pw.value.match(user_pw_reg) == null ? 0 : user_pw.value.match(user_pw_reg).length;
				if(spcl_char_num < 2){
					user_pw_errmsg.setAttribute("style", "visibility: visible");
					user_pw_errmsg.innerHTML += "특수문자를 반드시 2글자 이상 넣어야합니다<br>";
					flg = false;
				}
				if(user_pw.value.length < 8){
					user_pw_errmsg.setAttribute("style", "visibility: visible");
					user_pw_errmsg.innerHTML += "비밀번호를 최소 8자리 입력해주세요<br>";
					flg = false;
				}
				if(flg == true){
					user_pw_errmsg.setAttribute("style", "visibility: hidden");
					user_pw_errmsg.innerHTML = "";
				}
			}
			
		});
		
		user_pw.addEventListener("keydown",function(e){
			
  			if (e.getModifierState("CapsLock")) {
				user_pw_onCaps.innerHTML = "CAPS LOCK이 켜져있습니다";
				user_pw_onCaps.style = "visibility: visible";
  			}else {
    			user_pw_onCaps.style = "visibility: hidden";
  			}
		});
		
		//비밀번호 확인: 일치하는지
		
	
		user_pw_check.onchange=function(){
			
			
			if(user_pw_check.value != user_pw.value){
				
				user_pw_check_errmsg.setAttribute("style", "visibility: visible");
				user_pw_check_errmsg.innerHTML = "비밀번호가 일치하지 않습니다";
			}else{
				user_pw_check_errmsg.setAttribute("style", "visibility: hidden");
				user_pw_check_errmsg.innerHTML = "";
			}
		}
		
		//회원가입 클릭시
		//양식에 적혀있는 것들을 재검증한 후 통과못하면 오류메세지 + 포커스
		
		function goBack(err_target, e){
			err_target.focus();
			e.preventDefault();
			alert("다시 입력해주세요");
		}
		btn_join.addEventListener("click", event =>{
			let spcl_char_num = user_pw.value.match(user_pw_reg) == null ? 0 : user_pw.value.match(user_pw_reg).length;
			
			console.log(user_name_reg.test(user_name.value));
			if(user_name_reg.test(user_name.value) == false){
				goBack(user_name, event);
				console.log("이름값: " + user_name.value);
				console.log("이름 확인: " +user_name_reg.test(user_name.value));
				console.log("이름 오류");
			}
			else if(new Date(user_birth.value) - Date.now() > 0 || user_birth.value == ""){
				goBack(user_birth, event);
				console.log("생년월일 오류");
			}
			else if(spcl_char_num < 2){
				goBack(user_pw, event);
				console.log("비번 오류1");
			}
			else if(user_pw.value.length < 8){
				goBack(user_pw, event);
				console.log("비번 오류2");
			}
			else if(user_pw_check.value != user_pw.value){
				goBack(user_pw_check, event);
				console.log("비번확인 오류");
			}
		
		})
		
		
	}
	