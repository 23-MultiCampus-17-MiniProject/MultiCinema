package com.mc.multicinema.moviecomment.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc.multicinema.moviecomment.dto.MovieCommentDTO;
import com.mc.multicinema.moviecomment.dto.MovieCommentSortDTO;

@Repository
public class MovieCommentDAO {
	@Autowired
	SqlSession session;
	
	public List<MovieCommentDTO> selectMovieCommentsInit(String movie_cd, String commentsCount) {
		HashMap<String, Integer> map = new HashMap<>();
		Integer movie_cd_parse = Integer.parseInt(movie_cd);
		Integer commentsCount_parse = Integer.parseInt(commentsCount);
		map.put("movie_cd", movie_cd_parse);
		map.put("commentsCount", commentsCount_parse);
		
		return session.selectList("selectMovieCommentInit", map);
		
	}

	public int insertMovieComment(MovieCommentDTO dto) {
		return session.insert("insertMovieComment", dto);
	}

	public MovieCommentDTO selectOneMovieComment(HashMap<String, Integer> map) {
		return session.selectOne("selectOneMovieComment", map);
		
	}

	public int insertOneLike(HashMap<String, Integer> map) {
		
		return session.insert("insertOneLike", map);
	}

	public int updateOneLike(HashMap<String, Integer> map) {
		
		return session.update("updateOneLike", map);
	}

	public String selectOneLike(HashMap<String, Integer> map) {
		
		return session.selectOne("selectOneLike", map);
	}

	public int deleteComment(int comment_num) {
		
		return session.delete("deleteComment", comment_num);
	}

	public int deleteCommentLike(int comment_num) {
		
		return session.delete("deleteCommentLike", comment_num);
	}

	public int updateMovieComment(MovieCommentDTO dto) {
		
		return session.update("updateMovieComment", dto);
	}

	public List<MovieCommentDTO> selectListComment(MovieCommentSortDTO dto) {
		
		return session.selectList("selectListComment", dto);
	}

}