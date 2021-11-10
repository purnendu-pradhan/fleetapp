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
import com.purn.fleetapp.model.Location;
import com.purn.fleetapp.model.State;
import com.purn.fleetapp.service.CountryService;
import com.purn.fleetapp.service.LocationService;
import com.purn.fleetapp.service.StateService;

@Controller
public class LocationController {

	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private LocationService locationService;

	@GetMapping("/locations")
	public String getLocations(Model model) {

		List<State> statesList = stateService.getStates();
		model.addAttribute("states", statesList);

		List<Location> locationsList = locationService.getLocations();
		model.addAttribute("locations", locationsList);

		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);

		return "location";
	}

	@PostMapping("/locations/addNew")
	public String addLocation(Location location) {
		locationService.addLocation(location);
		return "redirect:/locations";
	}

	@RequestMapping("locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id) {
		return locationService.findById(id);
	}

	@RequestMapping(value = "/locations/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateLocation(Location location) {
		locationService.addLocation(location);
		return "redirect:/locations";
	}

	@RequestMapping(value = "/locations/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteLocation(Integer id) {
		locationService.deleteLocation(id);
		return "redirect:/locations";
	}
}
