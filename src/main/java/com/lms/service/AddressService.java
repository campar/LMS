package com.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Address;
import com.lms.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressrepository;
	
	public List<Address> getAllAddresses(){
		List<Address> addresses = new ArrayList<>();
		addressrepository.findAll().forEach(addresses::add);
		return addresses;
	}
}
