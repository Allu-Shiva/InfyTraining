package com.example.demo.dto;

import com.example.demo.entity.SimDetails;


public class SimDetailsDTO{
	
	private int simId;
	private long serviceNumber;
	private long simNumber;
	private String simStatus;
    private SimOffersDTO simOffers;

	
	
	public SimDetailsDTO() {}
	
	public SimDetailsDTO(int id,long serviceNumber,long simNumber,String status) {
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
	
	@Override
	public String toString() {
		return "Sim ID: "+simId+"\nService Number: "+serviceNumber+"\nSim Number: "+simNumber+"\nSim Status: "+simStatus;
	}

	public SimOffersDTO getSimOffers() {
		return simOffers;
	}

	public void setSimOffers(SimOffersDTO simOffers) {
		this.simOffers = simOffers;
	}
	public static SimDetails prepareSimDetailsEntity(SimDetailsDTO simDetailsDTO) {
		SimDetails simDetails = new SimDetails();
		simDetails.setSimId(simDetailsDTO.getSimId());
		simDetails.setSimNumber(simDetailsDTO.getSimNumber());
		simDetails.setServiceNumber(simDetailsDTO.getServiceNumber());
		simDetails.setSimStatus(simDetailsDTO.getSimStatus());
		simDetails.setSimOffers(SimOffersDTO.prepareSimOffersEntity(simDetailsDTO.getSimOffers()));

		return simDetails;
	}
	
	
}
