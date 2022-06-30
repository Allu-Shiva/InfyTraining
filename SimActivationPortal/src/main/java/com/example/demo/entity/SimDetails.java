package com.example.demo.entity;
import javax.persistence.*;

import com.example.demo.dto.SimDetailsDTO;

@Table(name="sim_details")
@Entity
public class SimDetails{
	@Id
	@Column(name="sim_id")
	private int simId;
	
	@Column(name="service_number")
	private long serviceNumber;
	
	@Column(name="sim_number")
	private long simNumber;
	
	@Column(name="sim_status")
	private String simStatus;
	
	  @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "sim_id", referencedColumnName = "sim_id")
	    private SimOffers simOffers;
	
	
	public SimDetails() {}
	
	public SimDetails(int id,long serviceNumber,long simNumber,String status) {
		super();
		this.simId = id;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus=status;
	}

	public int getSimId() {
		return simId;
	}

	public void setSimId(int simId) {
		this.simId = simId;
	}

	public long getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public long getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(long simNumber) {
		this.simNumber = simNumber;
	}

	public String getSimStatus() {
		return simStatus;
	}

	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	
	
	
	public SimOffers getSimOffers() {
		return simOffers;
	}

	public void setSimOffers(SimOffers simOffers) {
		this.simOffers = simOffers;
	}

	@Override
	public String toString() {
		return "Sim ID: "+simId+"\nService Number: "+serviceNumber+"\nSim Number: "+simNumber+"\nSim Status: "+simStatus;
	}
	
	public static SimDetailsDTO prepareSimDetailsDTO(SimDetails simDetails) {
		SimDetailsDTO simDetailsDTO = new SimDetailsDTO();
		simDetailsDTO.setSimId(simDetails.getSimId());
		simDetailsDTO.setSimNumber(simDetails.getSimNumber());
		simDetailsDTO.setServiceNumber(simDetails.getServiceNumber());
		simDetailsDTO.setSimStatus(simDetails.getSimStatus());
		
		
		
		simDetailsDTO.setSimOffers(SimOffers.prepareSimOffersDTO(simDetails.getSimOffers()));
		
		return simDetailsDTO;
	}
	
}
