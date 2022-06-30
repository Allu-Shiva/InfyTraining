package com.example.demo.dto;

import com.example.demo.entity.SimOffers;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class SimOffersDTO {
private int offerId;
	

	private int callQty;

	private int cost;

	private int dataQty;

	private int duration;
	
	private String offerName;
	
	private int simId;
	
	@JsonIgnore
	private SimDetailsDTO simDetails;

	
	public SimOffersDTO() {}

	public SimOffersDTO(int offerId, int callQty, int cost, int dataQty, int duration, String offerName, int simId) {
		super();
		this.offerId = offerId;
		this.callQty = callQty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerName = offerName;
		this.simId = simId;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getCallQty() {
		return callQty;
	}

	public void setCallQty(int callQty) {
		this.callQty = callQty;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDataQty() {
		return dataQty;
	}

	public void setDataQty(int dataQty) {
		this.dataQty = dataQty;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public int getSimId() {
		return simId;
	}

	public void setSimId(int simId) {
		this.simId = simId;
	}
	
	

	public SimDetailsDTO getSimDetails() {
		return simDetails;
	}

	public void setSimDetails(SimDetailsDTO simDetails) {
		this.simDetails = simDetails;
	}

	@Override
	public  String toString() {
		return "SimOffers [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + ", simId=" + simId + "]";
	}
	
	public static SimOffers prepareSimOffersEntity(SimOffersDTO simOffersDTO) {

			SimOffers simOffers = new SimOffers();
			simOffers.setOfferId(simOffersDTO.getOfferId());
			simOffers.setCallQty(simOffersDTO.getCallQty());
			simOffers.setCost(simOffersDTO.getCost());
			simOffers.setDataQty(simOffersDTO.getDataQty());
			simOffers.setDuration(simOffersDTO.getDuration());
			simOffers.setOfferName(simOffersDTO.getOfferName());
			simOffers.setSimId(simOffersDTO.getSimId());

			
			return simOffers;
		
	}
	

}
