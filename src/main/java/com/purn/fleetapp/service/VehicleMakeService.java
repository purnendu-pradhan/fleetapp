package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.VehicleMake;
import com.purn.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository makeRepository;
	
	public List<VehicleMake> getVehicleMakes() {
		return makeRepository.findAll();
	}

	public void save(VehicleMake vehicleMake) {
		makeRepository.save(vehicleMake);
	}

	public Optional<VehicleMake> findById(int id) {
		return makeRepository.findById(id);
	}

	public void delete(int id) {
		makeRepository.deleteById(id);
	}
}
