package nl.thuis.tutorial.springwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.thuis.tutorial.springwebapp.entity.Customer;
import nl.thuis.tutorial.springwebapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	// Using @RequestMapping without specifying the method will support all methods (GET, POST, etc)
	// @GetMapping = @RequestMapping with method = GET
	// @PostMapping = @RequestMapping with method = POST
	@GetMapping("/list")
	public String showList(Model model) {
		
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	// @GetMapping = @RequestMapping with method = GET
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// Create model that can be added to database later
		Customer customer = new Customer();
		model.addAttribute("customer", customer);		
		
		return "customer-form";
	}
	
	// @PostMapping = @RequestMapping with method = POST
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
}
