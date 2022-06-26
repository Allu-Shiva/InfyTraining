package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.example.demo.dto.DirectorDTO;

@Entity
public class Director {
	@Id
	@Column(name="Director_Id")
	private int directorId;
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	@Column(name="Contact_Number")
	private long contactNumber;
	@Column(name="Email")
	private String email;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="directors")
	private List<Movie> movies = new ArrayList<>();
	
	

	public Director() {
	}
	
	public Director(int id,String fname,String lname,long phno,String email) {
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
	
	@Override
	public String toString() {
		return "Director ID: "+directorId+"\nFirst Name: "+firstName+"\nLast Name: "+lastName+"\nContact Number: "+contactNumber+"\nEmail: "+email;
	}
	
	public static DirectorDTO prepareDirectorDTO(Director dirEnt) {
		DirectorDTO dirDTO = new DirectorDTO();
		dirDTO.setDirectorId(dirEnt.getDirectorId());
		dirDTO.setFirstName(dirEnt.getFirstName());
		dirDTO.setLastName(dirEnt.getLastName());
		dirDTO.setContactNumber(dirEnt.getContactNumber());
		dirDTO.setEmail(dirEnt.getEmail());
		
		return dirDTO;
	}
	

}
