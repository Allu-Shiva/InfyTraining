package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.demo.dto.CustomerAddressDTO;


@Entity
public class CustomerAddress {
	
	@Id
	@NotNull
	@Column(name="address_id")
	private int addressId;
//	@Max(value=25,message="Address should be maximum of 25 characters")
	@Column(name="address")
	private String address;
//	@Pattern(regexp="^[a-zA-Z\s]",message="City should not contain any special characters except space")
	private String city;
//	@Min(value=100000,message="Pin should be 6 digit number")
//	@Min(value=999999,message="Pin should be 6 digit number")
	private int pincode;
//	@Pattern(regexp="^[a-zA-Z\s]",message="State should not contain any special characters except space")
	private String state;
	

	
	@OneToOne(mappedBy="customerAddress")
	private Customer customer;
	
	
	public CustomerAddress() {
		super();
	}
	
	
	public CustomerAddress(int addressId, String address, String city, int pincode, String state) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}


	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + "]";
	}

	
	public static CustomerAddressDTO prepareCustomerAddressDTO(CustomerAddress customerAddress) {

		CustomerAddressDTO customerAddressDTO = new CustomerAddressDTO();
		
		customerAddressDTO.setAddressId(customerAddress.getAddressId());
		customerAddressDTO.setAdress(customerAddress.getAddress());
		customerAddressDTO.setCity(customerAddress.getCity());
		customerAddressDTO.setPincode(customerAddress.getPincode());
		customerAddressDTO.setState(customerAddress.getState());
		
		customerAddressDTO.setCustomer(Customer.prepareCustomerDTO(customerAddress.getCustomer()));
		return customerAddressDTO;
	}
	
	

}
