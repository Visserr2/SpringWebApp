package nl.thuis.tutorial.springwebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.thuis.tutorial.springwebapp.entity.Customer;
import nl.thuis.tutorial.springwebapp.repository.CustomerRepository;
import nl.thuis.tutorial.springwebapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	// use @Transactional always on the service layer
	
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerRepository.getCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerRepository.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerRepository.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerRepository.deleteCustomer(id);
	}
}
