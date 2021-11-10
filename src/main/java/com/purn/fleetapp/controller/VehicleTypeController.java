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

import com.purn.fleetapp.model.VehicleType;
import com.purn.fleetapp.service.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicleTypes")
	public String getVehicleTypes(Model model) {

		List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypes);

		return "vehicletype";
	}

	@PostMapping("vehicleTypes/addNew")
	public String addVehicleType(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}

	@RequestMapping("vehicleTypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeService.findById(id);
	}

	@RequestMapping(value = "vehicleTypes/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicleType(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}

	@RequestMapping(value = "vehicleTypes/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicleType(Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicleTypes";
	}
}
