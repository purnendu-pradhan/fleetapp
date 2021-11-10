package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.Country;
import com.purn.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getCountries() {
		return countryRepository.findAll();
	}

	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}
	public void deleteCountry(Integer id ) {
		countryRepository.deleteById(id);
	}
}
