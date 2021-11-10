package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.Supplier;
import com.purn.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	public void addSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	public Optional<Supplier> findById(Integer id) {
		return supplierRepository.findById(id);
	}

	public void deleteSupplier(Integer id) {
		supplierRepository.deleteById(id);
	}
}
