package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.VehicleMaintenance;
import com.purn.fleetapp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {

	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	//Return list of VehicleMaintenances
	public List<VehicleMaintenance> findAll(){
		return vehicleMaintenanceRepository.findAll();
	}
	
	//Save new VehicleMaintenance
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	//get by id
	public Optional<VehicleMaintenance> findById(int id){
		return vehicleMaintenanceRepository.findById(id);
	}
	//delete by id
	public void delete(int id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
}
