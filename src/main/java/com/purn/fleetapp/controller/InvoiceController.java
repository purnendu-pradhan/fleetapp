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

import com.purn.fleetapp.service.ClientService;
import com.purn.fleetapp.service.InvoiceService;
import com.purn.fleetapp.service.InvoiceStatusService;
import com.purn.fleetapp.model.Invoice;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoice")
	public String findAllInvoice(Model model) {

		model.addAttribute("invoices", invoiceService.findAllInvoice());
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
		return "invoice";
	}

	@PostMapping(value = "invoices/addNew")
	public String addInvoice(Invoice invoice) {
		invoiceService.addInvoice(invoice);
		return "redirect:/invoice";
	}

	@RequestMapping("invoices/findById")
	@ResponseBody
	public Optional<Invoice> findById(Integer id) {
		return invoiceService.findById(id);
	}

	@RequestMapping(value = "invoices/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateInvoice(Invoice invoice) {
		invoiceService.addInvoice(invoice);
		return "redirect:/invoice";
	}

	@RequestMapping(value = "invoices/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteInvoice(Integer id) {
		invoiceService.deleteInvoice(id);
		return "redirect:/invoice";
	}
}
