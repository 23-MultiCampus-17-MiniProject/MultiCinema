package com.mc.multicinema.moviecomment.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.multicinema.moviecomment.dao.MovieCommentDAO;
import com.mc.multicinema.moviecomment.dto.MovieCommentDTO;
import com.mc.multicinema.moviecomment.dto.MovieCommentSortDTO;

@Service
public class MovieCommentServiceImpl implements MovieCommentService{
	@Autowired
	MovieCommentDAO dao;
	
	@Override
	public int insertMovieComment(MovieCommentDTO dto) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("user_key", dto.getUser_key());
		map.put("movie_cd", dto.getMovie_cd());
		
		System.out.println("============="+dto.getUser_key() +"/"+ dto.getMovie_cd()+"=============");
		MovieCommentDTO result = dao.selectOneMovieComment(map);
		if(result != null) {
			System.out.println("=============이미 존재=============");
			return -2;
		}else {
			System.out.println("else 들어감");
			return dao.insertMovieComment(dto);
		}
		
	}

	@Override
	public String likeAdd(Integer comment_num, Integer user_key) {
		System.out.println("=================ser comnum:"+comment_num + "/" + "uskey" + user_key +"================");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("comment_num", comment_num);
		map.put("user_key", user_key);
		System.out.println("=================ser map comnum:"+map.get("comment_num")+ "/" + "uskey" + map.get("user_key") +"================");
		String res = dao.selectOneLike(map);
		if(res == null) {
			int isrtResult = dao.insertOneLike(map);
			int udtResult = dao.updateOneLike(map);
			if(isrtResult == -1) {
				//롤백
				return "insertOneLike 오류";
			}if(udtResult  == -1) {
				//롤백
				return "udtResultOneLike 오류";
			}else {
				return "좋아요 추가성공";
			}
		}else {
			return "중복";
		}
		
	}

	@Override
	public int deleteComment(int comment_num) {
		
		int res = dao.deleteCommentLike(comment_num);
		System.out.println("===============ser: " + res + "=========================");
		if(res == -1) {
			return -2;
		}else {
			return dao.deleteComment(comment_num);
		}
		
	}

	@Override
	public int updateMovieComment(MovieCommentDTO dto) {
		return dao.updateMovieComment(dto);	 
	}
	
	@Override
	public List<MovieCommentDTO> movieCommentsInit(String movie_cd) {
		String commentsCount = "10";
		System.out.println("service movieCommentInit 작동" + movie_cd);
		return dao.selectMovieCommentsInit(movie_cd, commentsCount);
		
	}

	@Override
	public List<MovieCommentDTO> moreComment(MovieCommentSortDTO dto) {

		return dao.selectListComment(dto);
		
	}

	@Override
	public List<MovieCommentDTO> sortComment(MovieCommentSortDTO dto) {
		
		return dao.selectListComment(dto);
	}
	
}
