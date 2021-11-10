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

import com.purn.fleetapp.model.VehicleModel;
import com.purn.fleetapp.service.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;

	@GetMapping("/vehicleModels")
	public String getVehicleModel(Model model) {

		List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModels);

		return "vehiclemodel";
	}

	@PostMapping("/vehiclemodels/addNew")
	public String save(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}

	@RequestMapping("vehiclemodels/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelService.findById(id);
	}

	@RequestMapping(value = "/vehiclemodels/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateVehicleModel(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}

	@RequestMapping(value = "/vehiclemodels/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteVehicleModel(int id) {
		vehicleModelService.deleteVehicleModel(id);
		return "redirect:/vehicleModels";
	}
}
