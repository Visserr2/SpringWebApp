package nl.thuis.tutorial.springwebapp.service;

import java.util.List;

import nl.thuis.tutorial.springwebapp.entity.Customer;

public interface CustomerService {

	Customer getCustomer(int id);
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	void deleteCustomer(int id);

}
