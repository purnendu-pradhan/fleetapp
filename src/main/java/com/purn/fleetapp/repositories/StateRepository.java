package com.purn.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purn.fleetapp.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
