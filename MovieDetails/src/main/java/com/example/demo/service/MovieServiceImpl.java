package com.example.demo.service;

import java.time.LocalDate;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

@Service("movieService")
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public void insertMovie(MovieDTO movie) {
		movieRepo.saveAndFlush(MovieDTO.prepareMovieEntity(movie));
		System.out.println("Record Inserted Successfully");
	}
	
	@Override
	public void getMovie(String title) {
//		Optional<Movie> opMovie =  Optional.of(movieRepo.findByMovieTitle(title));
//		try {
//		if(opMovie.isPresent()) {
//			Movie mv = opMovie.get();
//			System.out.println(mv);
//		}else {
//			throw new IllegalAccessError ("Invalid Movie Title");
//		}
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		if(movieRepo.findByMovieTitle(title)!=null) {
			Movie mv = movieRepo.findByMovieTitle(title);
			System.out.println(mv);
		}else {
			System.out.println("Invalid Movie Title");
		}
	}
	
	@Override
	public void displayMovies() {
		System.out.println(movieRepo.findAll());
	}
	
	@Override
	public void updateMovieReleaseDate(String title,LocalDate newdate) {
		Movie mv=movieRepo.findByMovieTitle(title);
		if(mv!=null) {
			mv.setDateReleased(newdate);
			System.out.println("Record Updated Successfully");
		}else {
			System.out.println("Record Not Found");
		}
	}
	
	@Override
	public void deleteMovie(String title) {
		if(movieRepo.deleteByMovieTitle(title)!=0) {
			System.out.println("Record deleted Successfully");
		}else {
			System.out.println("Record not found to delete");
		}
	}
	
	@Override
	public void getDirectorFromMovie(String title) {
		
		if(movieRepo.findByMovieTitle(title)!=null) {
			Movie mv = movieRepo.findByMovieTitle(title);
			System.out.println(mv.getDirectors());
		}else {
			System.out.println("Invalid Movie Title");
		}
	}

}
