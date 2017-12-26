package nl.thuis.tutorial.springwebapp.service;

import java.util.List;

import nl.thuis.tutorial.springwebapp.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);
}
