package com.example.demo.entity;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.dto.CustomerDTO;

@Table(name="customer")
@Entity
public class Customer {
	
	@Id
	@Column(name="unique_id_number")
//@Pattern(regexp="^[0-9]{16}",message="Id should be 16 digit")
//	@NotNull
	private String uniqueIdNumber;
	@Column(name="date_of_birth")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@NotNull
	private LocalDate dateOfBirth;
	@Column(name="email_address")
	private String emailAddress;
	@Column(name="first_name")
//	@NotNull
	private String firstName;
//	@NotNull 
	@Column(name="last_name")
	private String lastName;
	@Column(name="id_type")
	private String idType;
	@Column(name="customer_address_address_id")
	private int addressId;
	@Column(name="sim_id")
	private int simId;
	private String state;


	  @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private CustomerAddress customerAddress;
	
	public Customer() {}
	
	public Customer(String uniqueIdNumber, LocalDate dateOfBirth, String emailAddress, String firstName,
			String lastName, String idType, int addressId, int simId, String state) {
		super();
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		this.addressId = addressId;
		this.simId = simId;
		this.state = state;
	}
	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}
	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getSimId() {
		return simId;
	}
	public void setSimId(int simId) {
		this.simId = simId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@Override
	public String toString() {
		return "Customer [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", addressId=" + addressId + ", simId=" + simId + ", state=" + state
				+ "]";
	}
	
	public static CustomerDTO prepareCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setUniqueIdNumber(customer.getUniqueIdNumber());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		customerDTO.setEmailAddress(customer.getEmailAddress());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setIdType(customer.getIdType());
		customerDTO.setAddressId(customer.getAddressId());
		customerDTO.setSimId(customer.getSimId());
		customerDTO.setState(customer.getState());
		
		

		return customerDTO;
		
		
	}
	

}
