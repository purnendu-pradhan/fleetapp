package com.purn.fleetapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.purn.fleetapp.model.Country;
import com.purn.fleetapp.model.State;
import com.purn.fleetapp.service.CountryService;
import com.purn.fleetapp.service.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
    @Autowired
	private CountryService countryService;

	@GetMapping("/states")
	public String getStates(Model model) {

		List<State> statesList = stateService.getStates();
		model.addAttribute("states", statesList);

		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);

		return "state";
	}

	@PostMapping("/states/addNew")
	public String addState(State state) {
		stateService.addState(state);
		return "redirect:/states";
	}

	@RequestMapping("states/findById")
	@ResponseBody
	public Optional<State> findById(int id) {
		return stateService.findById(id);
	}

	@RequestMapping(value = "/states/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateState(State state) {
		stateService.addState(state);
		return "redirect:/states";
	}

	@RequestMapping(value = "/states/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteState(Integer id) {
		stateService.deleteState(id);
		return "redirect:/states";
	}
}
