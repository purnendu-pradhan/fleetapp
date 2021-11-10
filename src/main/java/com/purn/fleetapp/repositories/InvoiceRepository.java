package com.purn.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purn.fleetapp.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
