package com.purn.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purn.fleetapp.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
