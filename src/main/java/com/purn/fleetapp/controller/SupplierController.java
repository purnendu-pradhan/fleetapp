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

import com.purn.fleetapp.model.Supplier;
import com.purn.fleetapp.service.CountryService;
import com.purn.fleetapp.service.StateService;
import com.purn.fleetapp.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private SupplierService supplierService;

	@GetMapping("/suppliers")
	public String findSupplier(Model model) {
		model.addAttribute("suppliers", supplierService.findAll());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("countries", countryService.getCountries());
		return "supplier";
	}

	@PostMapping(value = "supplier/addNew")
	public String addSupplier(Supplier supplier) {
		supplierService.addSupplier(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "supplier/findById")
	@ResponseBody
	public Optional<Supplier> findById(Integer id) {
		return supplierService.findById(id);
	}

	@RequestMapping(value = "supplier/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateSupplier(Supplier supplier) {
		supplierService.addSupplier(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "supplier/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteSupplier(Integer id) {
		supplierService.deleteSupplier(id);
		return "redirect:/suppliers";
	}

}
