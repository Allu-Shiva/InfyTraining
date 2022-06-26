package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Director;
import com.example.demo.entity.Movie;



public class MovieDTO {

	private int movieId;

	private String movieTitle;

	private LocalDate dateReleased;

	private LocalTime movieRunningTime;
	
	private List<Director> directors = new ArrayList<>();

	
	public MovieDTO(){}
	
	public MovieDTO(int movieId,String movieTitle,LocalDate dateReleased,LocalTime movieRunningTime){
		super();
		this.movieId = movieId;
		this.movieTitle=movieTitle;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public LocalDate getDateReleased() {
		return dateReleased;
	}
	public void setDateReleased(LocalDate dateReleased) {
		this.dateReleased = dateReleased;
	}
	public LocalTime getMovieRunningTime() {
		return movieRunningTime;
	}
	public void setMovieRunningTime(LocalTime movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}
	

	

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	@Override
	public String toString() {
		return "Movie ID: "+movieId+"\nTitle: "+movieTitle+"\nRelease Date: "+dateReleased+"\nRun Time: "+movieRunningTime;
	}
	
	public static Movie prepareMovieEntity(MovieDTO movieDTO) {
		Movie mv = new Movie();
		mv.setMovieId(movieDTO.getMovieId());
		mv.setMovieTitle(movieDTO.getMovieTitle());
		mv.setDateReleased(movieDTO.getDateReleased());
		mv.setMovieRunningTime(movieDTO.getMovieRunningTime());
		mv.setDirectors(movieDTO.getDirectors());

		return mv;
	}
	
}
