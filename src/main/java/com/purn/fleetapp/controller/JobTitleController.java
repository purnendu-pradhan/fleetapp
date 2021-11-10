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

import com.purn.fleetapp.model.JobTitle;
import com.purn.fleetapp.service.JobTitleService;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping("/jobTitles")
	public String getJobTitles(Model model) {

		List<JobTitle> jobTitles = jobTitleService.getJobTitles();
		model.addAttribute("jobTitles", jobTitles);

		return "jobtitle";
	}

	@PostMapping("/jobTitles/addNew")
	public String addJobTitle(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}

	@RequestMapping("jobTitles/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id) {
		return jobTitleService.findById(id);
	}

	@RequestMapping(value = "/jobTitles/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateJobTitle(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}

	@RequestMapping(value = "/jobTitles/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteJobTitle(Integer id) {
		jobTitleService.delete(id);
		return "redirect:/jobTitles";
	}
}
