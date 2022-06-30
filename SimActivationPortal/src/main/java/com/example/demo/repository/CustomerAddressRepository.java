package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CustomerAddress;


@Repository
public interface CustomerAddressRepository extends  JpaRepository<CustomerAddress,Integer>{

}
