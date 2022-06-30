package com.example.demo.controller;



import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.SimDetailsDTO;
import com.example.demo.dto.SimOffersDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerAddress;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.CustomerService;
import com.example.demo.service.SimDetailsService;


import io.swagger.v3.oas.annotations.responses.ApiResponse;


//import io.swagger.v3.oas.annotations.OpenAPIDefinition;


//@OpenAPIDefinition(info= @Info(title="Welcome to SIM Activation Portal",version="3.14"))
@Validated
@RequestMapping("/simportal")
@RestController
public class SimPortalController {
	@Autowired
	SimDetailsService simDetailsService;
	
	@Autowired
	CustomerService customerService;
	
	@ApiResponse(description="Validate SIM to fetch Offers for you")
	@GetMapping("/{serviceNumber}/{simNumber}")
	public ResponseEntity<String> fetchSimOffers(

			 @Min(value=1000000000L, message = "Invalid details, please check again Service number")
			 @Max(value=9999999999L, message = "Invalid details, please check again Service number")
			 @PathVariable Long serviceNumber,
			 
			 @Min(value=1000000000000L, message = "Invalid details, please check again Service number")
			 @Max(value=9999999999999L, message = "Invalid details, please check again Service number")
			@PathVariable Long simNumber) throws UserNotFoundException {
		
			SimDetailsDTO simDetails = simDetailsService.fetchSimOffers(serviceNumber,simNumber);
			String msg = "";
			if(simDetails.getSimStatus().equals("active")) {
				msg= "SIM is already Active";
			}else {
				SimOffersDTO simOffers =simDetails.getSimOffers();
				msg= "SimOffers [offerId=" + simOffers.getOfferId() + ",\n callQty=" + simOffers.getCallQty() + ",\n cost=" + simOffers.getCost()+ ",\n dataQty=" + simOffers.getDataQty()
						+ "\n duration=" + simOffers.getDuration() + "\n offerName=" + simOffers.getOfferName() + "\n simId=" + simOffers.getSimId()+ "]";
			}
			ResponseEntity<String> entity = new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
			return entity;
		}
	

	
	@GetMapping("activation/{emailId}/{dob}")
	public ResponseEntity<String> activateSim(
			@Email(message="Enter valid Email Id", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
			@NotNull(message="Email Id is Required")
			@PathVariable String emailId,
			
			 @DateTimeFormat(pattern = "yyyy-MM-dd")
		    @NotNull(message = "DOB is Required")
			@PathVariable String dob
			) throws UserNotFoundException{
		
		CustomerDTO customerDTO = customerService.simActivation(emailId, LocalDate.parse(dob));

		String msg="No request placed for you";
		if(customerDTO!=null) {
			msg="Success!";
		}
		ResponseEntity<String> entity = new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
		return entity;
	}
	
	


	@GetMapping("customer/{fname}/{lname}/{email}")
	public ResponseEntity<String> activateSim(
			@Pattern(regexp="^[a-zA-Z]{1,15}",message="first name should be between 1 to 15 characters with no special characters")
			@PathVariable String fname,
			@Pattern(regexp="^[a-zA-Z]{1,15}",message="last name should be between 1 to 15 characters with no special characters")
			@PathVariable String lname,
			@Email(message="Enter valid Email Id", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
			@PathVariable String email
			) throws UserNotFoundException{
		
		CustomerDTO customerDTO = customerService.customerValidation(fname,lname);
		String msg="Invalid email details!!";

//		System.out.println(customerDTO.getCustomerAddress());
		if(customerDTO.getEmailAddress().equalsIgnoreCase(email)) {
			msg="Success!";
		}
		ResponseEntity<String> entity = new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
		return entity;
	}
	
	@PutMapping("/{uniqueId}")
	public ResponseEntity<String> updateAddress(
			@PathVariable String uniqueId,
			@Valid @RequestBody CustomerAddress customerAddress
			) throws UserNotFoundException{
		
		String msg	 = customerService.updateAddress(uniqueId,customerAddress);
		ResponseEntity<String> entity = new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
		return entity;
	}
	
	
	@PostMapping()
	public ResponseEntity<String> idProofValidation(@RequestBody Customer c) throws UserNotFoundException{
		String msg = customerService.validateIdProof(c);
		ResponseEntity<String> entity = new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
		return entity;
		
	}
	
	

	}

