package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.State;
import com.purn.fleetapp.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<State> getStates() {
		return stateRepository.findAll();
	}

	public void addState(State state) {
		stateRepository.save(state);
	}

	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}
	public void deleteState(Integer id ) {
		stateRepository.deleteById(id);
	}
}
