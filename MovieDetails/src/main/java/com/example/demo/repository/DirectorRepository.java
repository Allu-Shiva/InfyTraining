package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Director;

public interface DirectorRepository extends JpaRepository<Director,Integer>{
	public Director findByFirstNameAndLastName(String fname,String lname);

}
