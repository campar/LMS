package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Address;
import com.lms.service.AddressService;

@CrossOrigin
@RequestMapping
@RestController
public class AddressController {

	@Autowired
	private AddressService adressService;

	@GetMapping("/addresses")
	public List<Address> getAllAddresses() {
		return adressService.getAllAddresses();
	}
}
