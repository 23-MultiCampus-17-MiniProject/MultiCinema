package com.mc.multicinema.movieinfo.dto;

import org.springframework.stereotype.Component;

@Component
public class MovieDTO {
	
	int movie_cd;
	String movie_title;
	String movie_img_src;
	String movie_spec;
	String movie_openDt;
	String movie_showTm;
	String movie_type;
	String movie_makeNt;
	String movie_genre;
	String movie_director;
	int movie_limitAge;
	
	
	public int getMovie_cd() {
		return movie_cd;
	}
	public void setMovie_cd(int movie_cd) {
		this.movie_cd = movie_cd;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getMovie_img_src() {
		return movie_img_src;
	}
	public void setMovie_img_src(String movie_img_src) {
		this.movie_img_src = movie_img_src;
	}
	public String getMovie_spec() {
		return movie_spec;
	}
	public void setMovie_spec(String movie_spec) {
		this.movie_spec = movie_spec;
	}
	public String getMovie_openDt() {
		return movie_openDt;
	}
	public void setMovie_openDt(String movie_openDt) {
		this.movie_openDt = movie_openDt;
	}
	public String getMovie_showTm() {
		return movie_showTm;
	}
	public void setMovie_showTm(String movie_showTm) {
		this.movie_showTm = movie_showTm;
	}
	public String getMovie_type() {
		return movie_type;
	}
	public void setMovie_type(String movie_type) {
		this.movie_type = movie_type;
	}
	public String getMovie_makeNt() {
		return movie_makeNt;
	}
	public void setMovie_makeNt(String movie_makeNt) {
		this.movie_makeNt = movie_makeNt;
	}
	public String getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}
	public String getMovie_director() {
		return movie_director;
	}
	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}
	public int getMovie_limitAge() {
		return movie_limitAge;
	}
	public void setMovie_limitAge(int movie_limitAge) {
		this.movie_limitAge = movie_limitAge;
	}
	
	
}
