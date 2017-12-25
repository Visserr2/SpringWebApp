package nl.thuis.tutorial.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/list")
	public String showList(Model model) {
		
		return "list-customers";
	}
	
}
