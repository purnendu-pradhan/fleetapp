package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.Invoice;
import com.purn.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	public List<Invoice> findAllInvoice() {
		return invoiceRepository.findAll();
	}

	public void addInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	public Optional<Invoice> findById(Integer id) {
		return invoiceRepository.findById(id);
	}

	public void deleteInvoice(Integer id) {
		invoiceRepository.deleteById(id);
	}
}
