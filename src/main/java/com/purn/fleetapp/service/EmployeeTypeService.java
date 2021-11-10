package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.EmployeeType;
import com.purn.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository typeRepository;
	
	public List<EmployeeType> getEmployeeTypes() {
		return typeRepository.findAll();
	}

	public void save(EmployeeType employeeType) {
		typeRepository.save(employeeType);
	}

	public Optional<EmployeeType> findById(int id) {
		return typeRepository.findById(id);
	}

	public void delete(int id) {
		typeRepository.deleteById(id);
	}
}
