package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.VehicleStatus;
import com.purn.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository statusRepository;
	
	public List<VehicleStatus> getVehicleStatus() {
		return statusRepository.findAll();
	}

	public void save(VehicleStatus vehicleStatus) {
		statusRepository.save(vehicleStatus);
	}

	public Optional<VehicleStatus> findById(int id) {
		return statusRepository.findById(id);
	}

	public void delete(int id) {
		statusRepository.deleteById(id);
	}
}
