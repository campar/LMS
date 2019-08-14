package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.model.Country;


public interface CountryRepository extends CrudRepository<Country, Integer>{

}
