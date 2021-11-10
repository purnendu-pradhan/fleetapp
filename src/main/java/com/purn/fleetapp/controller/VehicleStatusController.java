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

import com.purn.fleetapp.model.VehicleStatus;
import com.purn.fleetapp.service.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService statusService;

	@GetMapping("/vehicleStatus")
	public String getVehicleStatuss(Model model) {

		List<VehicleStatus> vehicleStatus = statusService.getVehicleStatus();
		model.addAttribute("vehicleStatus", vehicleStatus);

		return "vehiclestatus";
	}

	@PostMapping("/vehicleStatus/addNew")
	public String addVehicleStatus(VehicleStatus vehicleStatus) {
		statusService.save(vehicleStatus);
		return "redirect:/vehicleStatus";
	}

	@RequestMapping("vehicleStatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id) {
		return statusService.findById(id);
	}

	@RequestMapping(value = "/vehicleStatus/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicleStatus(VehicleStatus vehiclestatus) {
		statusService.save(vehiclestatus);
		return "redirect:/vehicleStatus";
	}

	@RequestMapping(value = "/vehicleStatus/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicleStatus(Integer id) {
		statusService.delete(id);
		return "redirect:/vehicleStatus";
	}
}
