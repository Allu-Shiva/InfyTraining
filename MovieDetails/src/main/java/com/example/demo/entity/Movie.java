package com.example.demo.entity;

//import java.sql.Date;
import java.time.LocalDate;

//import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.demo.dto.DirectorDTO;
import com.example.demo.dto.MovieDTO;





@Table(name = "movie")
@Entity
public class Movie {
	@Id
	@Column(name="Movie_Id")
	private int movieId;
	@Column(name="Movie_Title")
	private String movieTitle;
	@Column(name="Date_Released")
	private LocalDate dateReleased;
	@Column(name="Movie_Running_Time")
	private LocalTime movieRunningTime;
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name="movieDirector",
//	joinColumns = @JoinColumn(name="movieId",referencedColumnName="Movie_Id"),
//	inverseJoinColumns = @JoinColumn(name="directorId",referencedColumnName="Director_Id")
//	)
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="movie_directors",
	joinColumns = {@JoinColumn(name="Movie_Id")},
	inverseJoinColumns = {@JoinColumn(name="Director_Id")}
			)
	private List<Director> directors = new ArrayList<>();
	
	

	public Movie(){}
	
	public Movie(int movieId,String movieTitle,LocalDate dateReleased,LocalTime movieRunningTime){
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
	
	public static MovieDTO prepareMovieDTO(Movie mv) {
		MovieDTO mvDTO = new MovieDTO();
		mvDTO.setMovieId(mv.getMovieId());
		mvDTO.setMovieTitle(mv.getMovieTitle());
		mvDTO.setDateReleased(mv.getDateReleased());
		mvDTO.setMovieRunningTime(mv.getMovieRunningTime());
		return mvDTO;
	}
	

}
