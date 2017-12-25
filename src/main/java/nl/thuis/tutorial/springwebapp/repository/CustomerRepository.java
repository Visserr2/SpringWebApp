package nl.thuis.tutorial.springwebapp.repository;

import java.util.List;

import nl.thuis.tutorial.springwebapp.entity.Customer;

public interface CustomerRepository {
	
	Customer getCustomer();
	
	List<Customer> getCustomers();
}