package com.example.demo;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CustomerAddress;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Transactional
@SpringBootApplication
public class SimActivationPortalApplication implements CommandLineRunner {
	
	@Autowired
	CustomerRepository customerRepo;


	public static void main(String[] args) {
		SpringApplication.run(SimActivationPortalApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{

		Customer c = new Customer("1234567891234567",LocalDate.parse("1990-12-12"),"smith@abc.com","Smith","John","Aadhar",1,1,"Karnataka");
		Customer c2 = new Customer("1234567891234568",LocalDate.parse("1998-12-12"),"bob@abc.com","Bob","Sam","Aadhar",2,2,"Karnataka");
		
		CustomerAddress ca = new CustomerAddress(1,"Jayanagar","Bangalore",560041,"Karnataka");
		CustomerAddress ca2 = new CustomerAddress(2,"Vijaynagar","Mysore",56717,"Karnataka");
		
		c.setCustomerAddress(ca);
		c2.setCustomerAddress(ca2);
		
		customerRepo.saveAndFlush(c);
		customerRepo.saveAndFlush(c2);
		
		
		
	}

}
