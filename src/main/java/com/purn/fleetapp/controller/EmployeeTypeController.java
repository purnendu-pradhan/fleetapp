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

import com.purn.fleetapp.model.EmployeeType;
import com.purn.fleetapp.service.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;

	@GetMapping("/employeeTypes")
	public String getEmployeeTypes(Model model) {

		List<EmployeeType> employeeTypes = employeeTypeService.getEmployeeTypes();
		System.out.println(employeeTypes);
		model.addAttribute("employeeTypes", employeeTypes);

		return "employeetype";
	}

	@PostMapping("/employeeTypes/addNew")
	public String addEmployeeType(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}

	@RequestMapping("employeeTypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeService.findById(id);
	}

	@RequestMapping(value = "/employeeTypes/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateEmployeeType(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}

	@RequestMapping(value = "/employeeTypes/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteEmployeeType(Integer id) {
		employeeTypeService.delete(id);
		return "redirect:/employeeTypes";
	}
}
