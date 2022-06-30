


package com.example.demo.dto;


import com.example.demo.entity.CustomerAddress;

public class CustomerAddressDTO {
	private Integer addressId;
	private String address;
	private String city;
	private int pincode;
	private String state;
	private CustomerDTO customer;
	
	public CustomerAddressDTO() {}
	
	public CustomerAddressDTO(Integer addressId, String address, String city, int pincode, String state) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String address) {
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
	
	

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
	

	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + "]";
	}
	
	public static CustomerAddress prepareCustomerAddressEntity(CustomerAddressDTO customerAddressDTO) {

		CustomerAddress customerAddress = new CustomerAddress();
		
		customerAddress.setAddressId(customerAddressDTO.getAddressId());
		customerAddress.setAddress(customerAddressDTO.getAdress());
		customerAddress.setCity(customerAddressDTO.getCity());
		customerAddress.setPincode(customerAddressDTO.getPincode());
		customerAddress.setState(customerAddressDTO.getState());
		
		customerAddress.setCustomer(CustomerDTO.prepareCustomerEntity(customerAddressDTO.getCustomer()));
		return customerAddress;
	}
	

}
