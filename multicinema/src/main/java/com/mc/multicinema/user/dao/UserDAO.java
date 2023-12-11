package com.mc.multicinema.user.dao;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpSession;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc.multicinema.moviehistory.MovieHistoryDTO;
import com.mc.multicinema.movieinfo.dto.MovieDTO;

import com.mc.multicinema.user.dto.UserDTO;

@Repository
public class UserDAO {
	
	@Autowired
	SqlSession session;
	
	public UserDTO loginProcess(String user_id, String user_pw) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		System.out.println("=========="+user_id+"/"+user_pw+"/"+map.get("user_id")+"/"+map.get("user_pw")+"==========");
		return session.selectOne("login", map);
		
	}

	public List<UserDTO> memberCheckProcess(String user_id, String user_email) {
		HashMap<String, String> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("user_email", user_email);
		
		return session.selectList("selectMemberCheck", map);
	}

	public int memberJoinProcess(UserDTO dto) {
		
		return session.insert("memberInsert", dto);
	}

	
	// user가 본 영화 객체들 받기
	List<MovieDTO> loadMovieHistory() {
		
		return null;
	}
	
	// 로그인된 아이디의 비밀번호가 맞나 확인
	public String getPassword(UserDTO dto) {
		String pw = session.selectOne("getPassword",dto);
		return pw;
	}
	
	// 회원 이메일 수정
	public void changeUserEmail(UserDTO dto, String user_email) {
		String user_key = dto.getUser_key();
		Map map = new HashMap();
		
		map.put("user_key", user_key);
		map.put("user_email", user_email);
		
		session.update("changeEmail",map);
	}
	
	// 회원 비밀번호 수정
	public void changeUserPw(UserDTO dto, String user_pw) {
		String user_key = dto.getUser_key();
		Map map = new HashMap();
		
		map.put("user_key", user_key);
		map.put("user_email", user_pw);
		
		session.update("changePw",map);
		
	}
	
	// 유저 키로 유저 dto 가져오기
	public UserDTO getUserByUserKey(String login_user_key) {
		UserDTO dto = session.selectOne("getUserByUserKey", login_user_key);
		return dto;
	}
	
	// 시청한 moviehistory DTO 가져오기
	public List<MovieHistoryDTO> getMovieList(int[] limit) {
		return session.selectList("pagingMovieList", limit);
	}
	
	// 총 시청한 영화 수 가져오기
	public int getTotalMovieBoard() {
		return session.selectOne("getTotalMovieBoard");
		
	}



}
