package com.purn.fleetapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purn.fleetapp.model.Client;
import com.purn.fleetapp.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public void addClient(Client client) {
		clientRepository.save(client);
	}

	public Optional<Client> findById(Integer id) {
		return clientRepository.findById(id);
	}

	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}
}
