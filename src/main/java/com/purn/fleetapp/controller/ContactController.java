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

import com.purn.fleetapp.model.Contact;
import com.purn.fleetapp.service.ContactService;
import com.purn.fleetapp.service.CountryService;
import com.purn.fleetapp.service.StateService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;

	@GetMapping("/contacts")
	public String findAll(Model model) {
		model.addAttribute("contacts", contactService.findAll());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("countries", countryService.getCountries());
		return "contact";
	}

	@PostMapping("/contacts/addNew")
	public String addContacts(Contact contact) {
		contactService.addContact(contact);
		return "redirect:/contacts";
	}

	@RequestMapping("/contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(Integer id) {
		return contactService.findById(id);
	}

	@RequestMapping(value = "/contacts/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateContact(Contact contact) {
		contactService.addContact(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/contacts/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteContact(Integer id) {
		contactService.deleteContact(id);
		return "redirect:/contacts";
	}
}
