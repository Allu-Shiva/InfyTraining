package com.example.demo.service;

import java.time.LocalDate;

import com.example.demo.dto.MovieDTO;
//import com.example.demo.entity.Movie;


public interface MovieService {
	
	public void insertMovie(MovieDTO movie);
	public void getMovie(String title);
	public void displayMovies();
	public void updateMovieReleaseDate(String title,LocalDate date);
	public void deleteMovie(String title);
	public void getDirectorFromMovie(String title);
	

}
