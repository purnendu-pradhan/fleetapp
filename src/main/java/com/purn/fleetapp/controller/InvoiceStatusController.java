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

import com.purn.fleetapp.model.InvoiceStatus;
import com.purn.fleetapp.service.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoiceStatus")
	public String getInvoiceStatuss(Model model) {

		List<InvoiceStatus> invoiceStatuses = invoiceStatusService.findAll();
		model.addAttribute("invoiceStatuses", invoiceStatuses);

		return "invoicestatus";
	}

	@PostMapping("/invoiceStatuses/addNew")
	public String addInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatus";
	}

	@RequestMapping("invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusService.findById(id);
	}

	@RequestMapping(value = "/invoiceStatuses/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatus";
	}

	@RequestMapping(value = "/invoiceStatuses/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteInvoiceStatus(Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoicestatus";
	}
}
