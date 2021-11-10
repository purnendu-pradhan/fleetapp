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

import com.purn.fleetapp.model.Vehicle;
import com.purn.fleetapp.service.EmployeeService;
import com.purn.fleetapp.service.LocationService;
import com.purn.fleetapp.service.VehicleMakeService;
import com.purn.fleetapp.service.VehicleModelService;
import com.purn.fleetapp.service.VehicleService;
import com.purn.fleetapp.service.VehicleStatusService;
import com.purn.fleetapp.service.VehicleTypeService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleTypeService vehicleTypeService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleModelService vehicleModelService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private VehicleStatusService vehicleStatusService;

	@GetMapping("/vehicle")
	public String findAll(Model model) {
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatus());
		return "vehicle";
	}

	@PostMapping("vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}

	@RequestMapping("vehicles/findById")
	@ResponseBody
	public Optional<Vehicle> findById(Integer id) {
		return vehicleService.findById(id);
	}

	@RequestMapping(value = "vehicles/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicle(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}

	@RequestMapping(value = "vehicles/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicle(Integer id) {
		vehicleService.delete(id);
		return "redirect:/vehicle";
	}
}
