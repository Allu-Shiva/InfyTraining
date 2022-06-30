package com.example.demo.service;


import java.util.Optional;

import javax.transaction.Transactional;

//import org.apache.catalina.mapper.Mapper;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SimDetailsDTO;
import com.example.demo.entity.SimDetails;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.SimDetailsRepository;



@Service
@Transactional
public class SimDetailsImpl implements SimDetailsService {
	
	@Autowired
	private SimDetailsRepository simDetailsRepository;
	

	
	@Override
	public SimDetailsDTO fetchSimOffers(Long serviceNumber,Long simNumber) throws UserNotFoundException{
		Optional<SimDetails> o = Optional.ofNullable(simDetailsRepository.findByServiceNumberAndSimNumber(serviceNumber,simNumber));
		if(o.isPresent()) {
		return SimDetails.prepareSimDetailsDTO(o.get());
		}else {
			throw new UserNotFoundException("Invalid details, please check again SIM number/Service number!");
		}
		
	}

}
