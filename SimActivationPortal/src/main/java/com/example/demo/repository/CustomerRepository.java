package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{

	Customer findByEmailAddressAndDateOfBirth(String email,LocalDate dob);
	 Customer findByFirstNameAndLastName(String fname,String lname);
}
