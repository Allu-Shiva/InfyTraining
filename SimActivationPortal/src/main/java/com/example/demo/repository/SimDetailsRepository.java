package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SimDetails;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails,Integer> {
	SimDetails findByServiceNumberAndSimNumber(Long serviceNumber,Long simNumber);

}
