package com.example.demo.service;

import com.example.demo.dto.DirectorDTO;

public interface DirectorService {
	public void insertDirector(DirectorDTO director);
	public void getDirectorMovies(String fname,String lname);
	public void updateDirector(String fname,String lname,Long phno,String email);

}
