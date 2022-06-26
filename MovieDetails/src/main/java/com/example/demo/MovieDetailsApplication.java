package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dto.DirectorDTO;
import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.Director;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.DirectorService;
import com.example.demo.service.MovieService;

@SpringBootApplication
@Transactional
public class MovieDetailsApplication implements CommandLineRunner{
	@Autowired
	ApplicationContext context;
	@Autowired
	MovieService movieService;
	@Autowired
	DirectorService dirService;
	


	public static void main(String[] args) {
		SpringApplication.run(MovieDetailsApplication.class, args);


	}

	
	@Override
	public void run(String... args) throws Exception{
		
		//creates movie record
//		MovieDTO mvDTO = new MovieDTO(1,"RRR",LocalDate.parse("2016-12-03"),LocalTime.parse("02:56:33"));
//		
//		//creates directors record for RRR movie
//		DirectorDTO dDTO = new DirectorDTO(111,"Rajmouli","SS",765432875,"rajmouli@gmail.com");
//		DirectorDTO dDTO2 = new DirectorDTO(112,"vamshi","paidipally",765432875,"vamshipaidipally@gmail.com");
//		
//		
//		//adding directors to the RRR directors list
//		mvDTO.getDirectors().add(DirectorDTO.prepareDirectorEntity(dDTO));
//		mvDTO.getDirectors().add(DirectorDTO.prepareDirectorEntity(dDTO2));
//		
//		//adding movies to the respective directors
//		dDTO.getMovies().add(MovieDTO.prepareMovieEntity(mvDTO));
//		dDTO2.getMovies().add(MovieDTO.prepareMovieEntity(mvDTO));
//		
//		//inserting the movie record automatically inserts the director and movie_director records
//		movieService.insertMovie(mvDTO);
//		
//		
//		//2nd record
//		MovieDTO mvDTO2 = new MovieDTO(2,"Pushpa",LocalDate.parse("2016-12-03"),LocalTime.parse("02:56:33"));
//		DirectorDTO dDTO3 = new DirectorDTO(113,"Sukumar","RR",765432875,"sukumar@gmail.com");
//		DirectorDTO dDTO4 = new DirectorDTO(112,"vamshi","paidipally",765432875,"vamshipaidipally@gmail.com");
//		
//		mvDTO2.getDirectors().add(DirectorDTO.prepareDirectorEntity(dDTO3));
//		mvDTO2.getDirectors().add(DirectorDTO.prepareDirectorEntity(dDTO4));
//		
//		dDTO3.getMovies().add(MovieDTO.prepareMovieEntity(mvDTO2));
//		dDTO4.getMovies().add(MovieDTO.prepareMovieEntity(mvDTO2));
//		
//		
		
//		1. Add movie
//		   Insert new Movie and Director details into the database.
//		movieService.insertMovie(mvDTO2);
//		
		
		
//		2. List movies based on the movie title
//		Display movies based on the title, if not present, then display exception with the message "Invalid Movie title".
//		movieService.getMovie("Pushpa");
//		
		
//		3. List movies based on director name
//		Display movie based on the director's first and last name, if the director's name is not present, then display exception with the message "Invalid Director name".
//		dirService.getDirectorMovies("vamshi", "paidipally");
		
		
//		4.List director's details based on the movie title
//		Display director's details based on the movie title, if not present, then display exception with message "Invalid Movie title"
//		movieService.getDirectorFromMovie("RRR");
		
		
//		5. View movies
//		Display all the movies 
//		movieService.displayMovies();
		
//		
//		6. Update the new release date for the existing movie and display appropriate error messages for invalid details.
//		movieService.updateMovieReleaseDate("Bahubali", LocalDate.parse("2000-04-30"));
		
		
		
//		7 - Update director details based on director first and last name
//		Provide the director's first name and last name to update his new address, contact number and display appropriate error messages for the invalid details.
//		dirService.updateDirector("vamshi", "paidipally", 985837463L, "vamshipaidipally18@gmail.com");
				
		
		
//		8.  Remove movie based on movie title
//		- Enter movie title to remove a movie, if the movie with the given title is not present, then display exception message as "Movie with the given title is not present" 
//		movieService.deleteMovie("pushpa");
		
		


		
		
		
	}
	



	
	

	}


