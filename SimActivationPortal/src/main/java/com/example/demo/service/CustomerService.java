package com.example.demo.service;

import java.time.LocalDate;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerAddress;
import com.example.demo.exception.UserNotFoundException;

public interface CustomerService {
	public CustomerDTO simActivation(String emailId,LocalDate dob) throws UserNotFoundException;
	
	public CustomerDTO customerValidation(String fname,String lname) throws UserNotFoundException;
	
	public String updateAddress(String uniqueId,CustomerAddress customerAddress) throws UserNotFoundException;
	
	public String validateIdProof(Customer c) throws UserNotFoundException;

}
