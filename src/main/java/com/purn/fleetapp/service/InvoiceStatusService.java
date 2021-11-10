package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.InvoiceStatus;
import com.purn.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository statusRepository;
	
	public List<InvoiceStatus> findAll() {
		return statusRepository.findAll();
	}

	public void save(InvoiceStatus invoiceStatus) {
		statusRepository.save(invoiceStatus);
	}

	public Optional<InvoiceStatus> findById(int id) {
		return statusRepository.findById(id);
	}

	public void delete(int id) {
		statusRepository.deleteById(id);
	}
}
