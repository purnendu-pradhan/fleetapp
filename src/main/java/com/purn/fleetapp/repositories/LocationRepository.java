package com.purn.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purn.fleetapp.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
