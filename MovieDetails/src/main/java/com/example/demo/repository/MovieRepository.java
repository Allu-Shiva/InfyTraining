package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	Movie findByMovieTitle(String title);
	int deleteByMovieTitle(String title);

}
