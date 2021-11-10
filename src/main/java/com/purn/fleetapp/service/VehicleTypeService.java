package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.VehicleType;
import com.purn.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository typeRepository;
	
	public List<VehicleType> getVehicleTypes() {
		return typeRepository.findAll();
	}

	public void save(VehicleType vehicleType) {
		typeRepository.save(vehicleType);
	}

	public Optional<VehicleType> findById(int id) {
		return typeRepository.findById(id);
	}

	public void delete(int id) {
		typeRepository.deleteById(id);
	}
}
