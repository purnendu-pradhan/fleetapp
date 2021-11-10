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

import com.purn.fleetapp.model.Employee;
import com.purn.fleetapp.service.CountryService;
import com.purn.fleetapp.service.EmployeeService;
import com.purn.fleetapp.service.EmployeeTypeService;
import com.purn.fleetapp.service.JobTitleService;
import com.purn.fleetapp.service.StateService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private JobTitleService jobTitleService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;

	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());

		return "employee";
	}

	@PostMapping("employees/addNew")
	public String saveEmployees(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}

	@RequestMapping("employees/findById")
	@ResponseBody
	public Optional<Employee> findById(Integer id) {
		return employeeService.findById(id);
	}

	@RequestMapping(value = "employees/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateEmployees(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}

	@RequestMapping(value = "employees/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteEmployee(Integer id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
}
