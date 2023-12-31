package com.mc.multicinema.moviecomment.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.mc.multicinema.moviecomment.dto.MovieCommentDTO;
import com.mc.multicinema.moviecomment.dto.MovieCommentSortDTO;

public interface MovieCommentService {

	int insertMovieComment(MovieCommentDTO dto);

	String likeAdd(Integer comment_num_parsed, Integer user_key_parsed);

	int deleteComment(int comment_num);

	int updateMovieComment(MovieCommentDTO dto);
	
	List<MovieCommentDTO> movieCommentsInit(String movie_cd);

	List<MovieCommentDTO> moreComment(MovieCommentSortDTO dto);

	List<MovieCommentDTO> sortComment(MovieCommentSortDTO dto);
	

}
