package com.purn.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purn.fleetapp.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
