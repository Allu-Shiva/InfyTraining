package com.example.demo.service;



import com.example.demo.dto.SimDetailsDTO;
import com.example.demo.exception.UserNotFoundException;


public interface SimDetailsService {
	public SimDetailsDTO fetchSimOffers(Long serviceNumber,Long simNumber) throws UserNotFoundException;
}
