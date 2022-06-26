package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Director;
import com.example.demo.entity.Movie;

public class DirectorDTO {
	private int directorId;
	private String firstName;
	private String lastName;
	private long contactNumber;
	private String email;
	private List<Movie> movies = new ArrayList<>();
	
	public DirectorDTO() {
	}
	
	public DirectorDTO(int id,String fname,String lname,long phno,String email) {
		super();
		this.directorId=id;
		this.firstName=fname;
		this.lastName=lname;
		this.contactNumber=phno;
		this.email=email;
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	


	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public static Director prepareDirectorEntity(DirectorDTO dirDTO) {
		Director dirEnt = new Director();
		dirEnt.setDirectorId(dirDTO.getDirectorId());
		dirEnt.setFirstName(dirDTO.getFirstName());
		dirEnt.setLastName(dirDTO.getLastName());
		dirEnt.setContactNumber(dirDTO.getContactNumber());
		dirEnt.setEmail(dirDTO.getEmail());
		
		return dirEnt;
	}
	
}
