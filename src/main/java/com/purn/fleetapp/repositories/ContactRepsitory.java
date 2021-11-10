package com.purn.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purn.fleetapp.model.Contact;

@Repository
public interface ContactRepsitory extends JpaRepository<Contact, Integer> {

}
