package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.Vehicle;
import com.purn.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//Get All Vehicles
	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
	}	
	
	//Get Vehicle By Id
	public Optional<Vehicle> findById(Integer id) {
		return vehicleRepository.findById(id);
	}	
	
	//Delete Vehicle
	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
	}
	
	//Update Vehicle
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
}
