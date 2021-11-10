package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.VehicleModel;
import com.purn.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository modelRepository;
	
	public List<VehicleModel> getVehicleModels() {
		return modelRepository.findAll();
	}

	public void save(VehicleModel vehicleModel) {
		modelRepository.save(vehicleModel);
	}

	public Optional<VehicleModel> findById(int id) {
		return modelRepository.findById(id);
	}

	public void deleteVehicleModel(int id) {
		modelRepository.deleteById(id);
	}
}
