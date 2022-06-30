package com.example.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerAddress;
import com.example.demo.entity.SimDetails;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.CustomerAddressRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.SimDetailsRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerAddressRepository caRepo;
	
	@Autowired
	SimDetailsRepository simDetailsRepo;
	
	@Override
	public CustomerDTO simActivation(String emailId,LocalDate dob) throws UserNotFoundException {
		Optional<Customer> o = Optional.ofNullable(customerRepository.findByEmailAddressAndDateOfBirth(emailId,dob));
		if(o.isPresent()) {
		return Customer.prepareCustomerDTO(o.get());
		}else {
			throw new UserNotFoundException("Invalid details, please check again EmailId/DOB");
		}
	}
	
	
	@Override
	public CustomerDTO customerValidation(String fname,String lname)  throws UserNotFoundException{
		Optional<Customer> o = Optional.ofNullable(customerRepository.findByFirstNameAndLastName(fname,lname));
		if(o.isPresent()) {
		return Customer.prepareCustomerDTO(o.get());
		}else {
			throw new UserNotFoundException("No customer found for the provided details");
		}
	}
	
	
	
	@Override
	public String updateAddress(String uniqueId,CustomerAddress customerAddress) throws UserNotFoundException{
		Optional<Customer> o = customerRepository.findById(uniqueId);
		if(o.isPresent()) {
			Customer cust = o.get();
			CustomerAddress custAd = cust.getCustomerAddress();
			custAd.setAddress(customerAddress.getAddress());
			custAd.setCity(customerAddress.getCity());
			custAd.setPincode(customerAddress.getPincode());
			custAd.setState(customerAddress.getState());
			caRepo.saveAndFlush(custAd);
			return "Update Successful!";
		}else {
				throw new UserNotFoundException("Oops! Invalid Id");
			}
	}
	
	@Override
	public String validateIdProof(Customer c) throws UserNotFoundException{
		Optional<Customer> o = customerRepository.findById(c.getUniqueIdNumber());
		if(o.isPresent()) {
			Customer customer = o.get();
			String msg = "";
			if(
				customer.getFirstName().equals(c.getFirstName())
				& customer.getLastName().equals(c.getLastName())
				& customer.getDateOfBirth().equals(c.getDateOfBirth())
					) {
				Optional<SimDetails> Opsim = simDetailsRepo.findById(customer.getSimId());
				SimDetails sd = Opsim.get();
				if(sd.getSimStatus().equals("active")) {
					msg="ID proof validated Successfully! SIM is already Active";
				}else {
					sd.setSimStatus("active");
					simDetailsRepo.saveAndFlush(sd);
					msg="ID proof validated Successfully! SIM Activation Successful";
				}
				
			}else {
				msg="Your credentials doesnt match with our database";
			}
			return msg;
		}else {
				throw new UserNotFoundException("Oops! Invalid Id");
			}
	}

}
