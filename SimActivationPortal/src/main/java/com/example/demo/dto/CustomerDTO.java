package com.example.demo.dto;

import java.time.LocalDate;


import com.example.demo.entity.Customer;


public class CustomerDTO {
	
	private String uniqueIdNumber;

	private LocalDate dateOfBirth;

	private String emailAddress;

	private String firstName;

	private String lastName;

	private String idType;

	private int addressId;

	private int simId;
	private String state;
	
//	@JsonIgnore
	private CustomerAddressDTO customerAddress;
//	
	public CustomerDTO() {}
	
	public CustomerDTO(String uniqueIdNumber, LocalDate dateOfBirth, String emailAddress, String firstName,
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
	
	
	public CustomerAddressDTO getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(CustomerAddressDTO customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@Override
	public String toString() {
		return "Customer [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", addressId=" + addressId + ", simId=" + simId + ", state=" + state
				+ "]";
	}
	
	
	public static Customer prepareCustomerEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		
		customer.setUniqueIdNumber(customerDTO.getUniqueIdNumber());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setEmailAddress(customerDTO.getEmailAddress());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setIdType(customerDTO.getIdType());
		customer.setAddressId(customerDTO.getAddressId());
		customer.setSimId(customerDTO.getSimId());
		customer.setState(customerDTO.getState());
		
		return customer;
		
		
	}
	

}
