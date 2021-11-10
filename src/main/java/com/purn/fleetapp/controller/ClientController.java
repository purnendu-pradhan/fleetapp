package com.purn.fleetapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.purn.fleetapp.service.ClientService;
import com.purn.fleetapp.service.CountryService;
import com.purn.fleetapp.service.StateService;
import com.purn.fleetapp.model.Client;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;

	@GetMapping("/clients")
	public String findAll(Model model) {

		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("countries", countryService.getCountries());

		return "client";
	}

	@PostMapping("/clients/addNew")
	public String addClients(Client client) {
		clientService.addClient(client);
		return "redirect:/clients";
	}

	@RequestMapping("clients/findById")
	@ResponseBody
	public Optional<Client> findById(Integer id) {
		return clientService.findById(id);
	}

	@RequestMapping(value = "/clients/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateClient(Client client) {
		clientService.addClient(client);
		return "redirect:/clients";
	}

	@RequestMapping(value = "/clients/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteClient(Integer id) {
		clientService.deleteClient(id);
		return "redirect:/clients";
	}
}
