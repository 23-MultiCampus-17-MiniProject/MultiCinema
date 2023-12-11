package com.mc.multicinema;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mc.multicinema.moviecomment.dto.MovieCommentDTO;
import com.mc.multicinema.moviecomment.dto.MovieCommentSortDTO;
import com.mc.multicinema.moviecomment.service.MovieCommentService;
import com.mc.multicinema.moviecomment.service.MovieCommentServiceImpl;
import com.mc.multicinema.movieinfo.dto.MovieDTO;
import com.mc.multicinema.user.dto.UserDTO;
import com.mc.multicinema.user.service.UserService;


@Controller
public class HomeController {
	@Autowired
	MovieService service;
	@Autowired
	UserService userservice;
	@Autowired
	MovieCommentService moviecommentservice;
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		ArrayList<DailyBoxOfficeDTO> list = service.dailyBoxOffice();
		System.out.println("컨트롤러" + list.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("movielist", list);
		mv.setViewName("mainpage");
		
		return mv;
	}
	
	@GetMapping("/login")
	public String login() {
		//로그인 이미 했을때 처리
		return "login";
	}
	
	@PostMapping("/login")
	public String loginProcess(String user_id, String user_pw, Model m, HttpSession session) {
		
		//id, pw 정보 있는지 확인
		//있으면 return 로그인을 눌렀던 그 페이지로
		//정보 있음
		System.out.println("=====================con"+user_id + user_pw+"=====================");
		UserDTO dto = userservice.loginProcess(user_id, user_pw);
		
		if(dto != null && dto.getUser_key() != null && dto.getUser_name() != null && dto.getUser_id() != null) {
			session.setAttribute("login_user_id", dto.getUser_id());
			session.setAttribute("login_user_key", dto.getUser_key());
			session.setAttribute("login_user_name", dto.getUser_name());
			
			
			//세션에 추가할 것
			//user_key,
			//아이디, 이름,
			return "redirect:/";
		}else {
			m.addAttribute("result", "아이디와 비밀번호가 일치하지 않습니다");
			return "login";
		}
	}
	
	@GetMapping("/membercheck")
	public String memberCheck() {
		return "member_check";
	}
	
	@PostMapping("/membercheck")

	public String memberCheckProcess(String user_id, String user_email, Model m) {
		
		//서비스 dao 멤버 있는지 확인 후
		//있다 modelandview 생성 후 model에 아이디 이메일값 넣어주고 회원가입 페이지로
		//없다 modelandview 생성 후 model에 이미 있는 회원이다 하고 모델만 주기
		//jsp에선 ${모델이름명}으로 들고와서 스크립트에서 alert 띄워주기
		List<UserDTO> list = userservice.memberCheckProcess(user_id, user_email);
		
		if(list.size() == 0) {
			m.addAttribute("result", "가입가능");
			m.addAttribute("user_id", user_id);
			m.addAttribute("user_email", user_email);
			return "member_check";
		}else {
			m.addAttribute("result", "이미 존재하는 회원입니다");
			return "member_check";
		}
	}
	
	@GetMapping("/memberjoin")
	public String memberjoinDeny() {
		
		return null;
	}
	
	@PostMapping("/memberjoin")
	public ModelAndView memberjoin(String user_id, String user_email) {
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user_id", user_id);
		mv.addObject("user_email", user_email);
		mv.setViewName("member_join");
		
		return mv;
	}
	
	@PostMapping("/welcome")
	public String welcome(UserDTO dto, Model m) {
		int res = userservice.memberJoinProcess(dto);
		if(res == -1) {
			System.out.println("db 오류");
			return "redirect:/memberjoin";
		}else {
			m.addAttribute("user_name", dto.getUser_name());
			return "welcome";
		}
		
		
	}
	
	@GetMapping("/moviedetail")
	public ModelAndView movieDetail(String movie_cd, HttpSession session) {
		
		MovieDTO dto = service.selectMovieDetailInfo(movie_cd);
		//movie_cd를 영화제목으로 변환한 후 stillCutService에 영화 제목 전달
		//db에 검색 후 전달
		String movie_title = "서울의 봄";
		ArrayList<String> stillCutUrlList = service.stillCutService(movie_title);
		List<MovieCommentDTO> commentlist = moviecommentservice.movieCommentsInit(movie_cd);
		//null일 경우 처리;
		ModelAndView mv = new ModelAndView();
		mv.addObject("movie_cd", movie_cd);
		mv.addObject("commentlist", commentlist);
		mv.addObject("stillcutlist", stillCutUrlList);
		mv.setViewName("movie_detail");
		return mv;	
	}
	
	@PostMapping("/moviedetail")
	public String insertMovieComment(MovieCommentDTO dto, HttpSession session) {
		// 한줄평 받아야할 정보
		// 유저 키, 컨텐츠, 점수, 영화코드
		System.out.println(dto.getComment_score());
		
		int result = moviecommentservice.insertMovieComment(dto);

		String message = "";
		if (result == -2) {
			message = "이미 한줄평을 등록하셨습니다";
		} else if (result == -1) {
			message = "db 등록 오류";
		} else {
			message = "등록되었습니다";
		}

		session.setAttribute("message", message);

		return "redirect:/moviedetail?movie_cd=" + dto.getMovie_cd();
	}
	
	@RequestMapping(value="/moviecommentlikeadd", produces = {"application/json;charset=utf-8"})
	public @ResponseBody String movieCommentLikeAdd(String comment_num, String user_key) {
		Integer comment_num_parsed = Integer.parseInt(comment_num);
		Integer user_key_parsed = Integer.parseInt(user_key);
		
		System.out.println("=================Con comnum:"+comment_num_parsed + "/" + "uskey" + user_key_parsed +"================");
		
		String result = moviecommentservice.likeAdd(comment_num_parsed, user_key_parsed);
		
		return "{\"result\": \"" + result + "\"}";
		
	}
	
	@PostMapping("/deletemoviecomment")
	public String deleteMovieComment(String comment_num, String movie_cd, HttpSession session) {
		System.out.println(comment_num);
		int comment_num_parsed = Integer.parseInt(comment_num);
		
		int res = moviecommentservice.deleteComment(comment_num_parsed);
		System.out.println("===============con: " + res + "=========================");
		if(res == -1) {
			session.setAttribute("message", "좋아요 삭제 오류");
		}else if(res == -2) {
			session.setAttribute("message", "코멘트 삭제 오류");
		}else {
			session.setAttribute("message", "성공적으로 삭제되었습니다");
			System.out.println("===============con: 성공적 삭제" + "=========================");
		}
		
		return "redirect:/moviedetail?movie_cd=" + movie_cd;
	}
	
	@PostMapping("/updatemoviecomment")
	public String updateMovieComment(MovieCommentDTO dto, HttpSession session) {
		
		int res = moviecommentservice.updateMovieComment(dto);
		if(res == -1) {
			session.setAttribute("message", "한줄평 수정 오류");
		}else {
			session.setAttribute("message", "성공적으로 수정되었습니다");
		}
		
		return "redirect:/moviedetail?movie_cd=" + dto.getMovie_cd();
		
	}
	
	@RequestMapping(value="/morecomment", produces = {"application/json;charset=utf-8"})
	public @ResponseBody List<MovieCommentDTO> moreComment(MovieCommentSortDTO dto) {
		
		List<MovieCommentDTO> list =moviecommentservice.moreComment(dto);
		return list;
		
	}
	
	@RequestMapping(value="/sortcomment", produces = {"application/json;charset=utf-8"})
	public @ResponseBody List<MovieCommentDTO> sortComment(MovieCommentSortDTO dto) {
		
		List<MovieCommentDTO> list =moviecommentservice.sortComment(dto);
		
		return list;
		
	}
}