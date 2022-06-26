package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DirectorDTO;
import com.example.demo.entity.Director;
import com.example.demo.entity.Movie;
import com.example.demo.repository.DirectorRepository;

@Service("directorService")
public class DirectorServiceImpl implements DirectorService{
	@Autowired
	private DirectorRepository directorRepo;
	
	@Override
	public void insertDirector(DirectorDTO dirDTO) {
		directorRepo.saveAndFlush(DirectorDTO.prepareDirectorEntity(dirDTO));
		System.out.println("Director record inserted successfully");
	}
	
	@Override
	public void getDirectorMovies(String fname,String lname) {
		Director dir = directorRepo.findByFirstNameAndLastName(fname, lname);
		System.out.println(dir.getMovies());
	}
	
	@Override
	public void updateDirector(String fname,String lname,Long phno,String email) {
		Director dir=directorRepo.findByFirstNameAndLastName(fname,lname);
		if(dir!=null) {
			dir.setContactNumber(phno);
			dir.setEmail(email);
			System.out.println("Record Updated Successfully");
		}else {
			System.out.println("Record Not Found");
		}
	}

}
