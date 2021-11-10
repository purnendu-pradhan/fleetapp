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

import com.purn.fleetapp.model.VehicleMovement;
import com.purn.fleetapp.service.LocationService;
import com.purn.fleetapp.service.VehicleMovementService;
import com.purn.fleetapp.service.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicleMovement")
	public String findAll(Model model) {
		model.addAttribute("vehicleMovements", vehicleMovementService.findAll());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("vehicles", vehicleService.getVehicles());

		return "vehicleMovement";
	}

	@PostMapping("vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovement";
	}

	@RequestMapping(value = "vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(Integer id) {
		return vehicleMovementService.findById(id);
	}

	@RequestMapping(value = "vehicleMovements/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);

		return "redirect:/vehicleMovement";
	}

	@RequestMapping(value = "vehicleMovements/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovement";
	}
}
