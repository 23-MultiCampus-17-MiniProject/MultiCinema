package com.mc.multicinema;

import java.util.ArrayList;
import java.util.List;

import com.mc.multicinema.moviecomment.dto.MovieCommentDTO;
import com.mc.multicinema.movieinfo.dto.MovieDTO;



public interface MovieService {
	public ArrayList<DailyBoxOfficeDTO> dailyBoxOffice();
	public MovieDTO selectMovieDetailInfo(String movieCd);
	public ArrayList<String> stillCutService(String movie_title);
	
	
	
}