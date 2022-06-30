package com.example.demo.entity;
import javax.persistence.*;

import com.example.demo.dto.SimOffersDTO;

@Entity
public class SimOffers {
	@Id
	@Column(name="offer_id")
	private int offerId;
	
	@Column(name="call_qty")
	private int callQty;
	
	@Column(name="cost")
	private int cost;
	
	@Column(name="data_qty")
	private int dataQty;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="offer_name")
	private String offerName;
	
	@Column(name="sim_id")
	private int simId;
	
	@OneToOne(mappedBy = "simOffers")
	private SimDetails simDetails;
	
	public SimOffers() {}

	public SimOffers(int offerId, int callQty, int cost, int dataQty, int duration, String offerName, int simId) {
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

	@Override
	public String toString() {
		return "SimOffers [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + ", simId=" + simId + "]";
	}

	public SimDetails getSimDetails() {
		return simDetails;
	}

	public void setSimDetails(SimDetails simDetails) {
		this.simDetails = simDetails;
	}
	
	public static SimOffersDTO prepareSimOffersDTO(SimOffers simOffers) {
		SimOffersDTO simOffersDTO = new SimOffersDTO();
		simOffersDTO.setOfferId(simOffers.getOfferId());
		simOffersDTO.setCallQty(simOffers.getCallQty());
		simOffersDTO.setCost(simOffers.getCost());
		simOffersDTO.setDataQty(simOffers.getDataQty());
		simOffersDTO.setDuration(simOffers.getDuration());
		simOffersDTO.setOfferName(simOffers.getOfferName());
		simOffersDTO.setSimId(simOffers.getSimId());
		
		return simOffersDTO;
	}
	
	
	
	
	
	
}
