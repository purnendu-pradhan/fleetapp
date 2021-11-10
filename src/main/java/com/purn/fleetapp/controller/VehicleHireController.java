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

import com.purn.fleetapp.model.VehicleHire;
import com.purn.fleetapp.service.ClientService;
import com.purn.fleetapp.service.LocationService;
import com.purn.fleetapp.service.VehicleHireService;
import com.purn.fleetapp.service.VehicleService;

@Controller
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private LocationService locationService;

	@GetMapping("/vehicleHire")
	public String addVehicleHire(Model model) {
		model.addAttribute("vehicleHires", vehicleHireService.findAll());
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("vehicles", vehicleService.getVehicles());

		return "vehicleHire";
	}

	@PostMapping("vehicleHire/addNew")
	public String addNewVehicleHire(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}

	@RequestMapping(value = "vehicleHire/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(Integer id) {
		return vehicleHireService.findById(id);
	}

	@RequestMapping(value = "vehicleHire/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHire";
	}

	@RequestMapping(value = "vehicleHire/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehicleHire";
	}
}
