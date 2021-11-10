package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.Location;
import com.purn.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<Location> getLocations() {
		return locationRepository.findAll();
	}

	public void addLocation(Location location) {
		locationRepository.save(location);
	}

	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	public void deleteLocation(int id) {
		locationRepository.deleteById(id);
	}
}
