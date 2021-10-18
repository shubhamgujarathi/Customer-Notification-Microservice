package com.cpm1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cpm1.model.Customer;
import com.cpm1.repository.CustomerRepository;
import com.cpm1.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);

	}

	@Transactional
	public Customer getCustomer(int theId) throws ResourceNotFoundException {
		return customerRepository.findById(theId).orElseThrow(() -> new ResourceNotFoundException(theId));
	}

	@Transactional
	public void deleteCustomer(int theId) throws ResourceNotFoundException {
		customerRepository.deleteById(theId);

	}

}