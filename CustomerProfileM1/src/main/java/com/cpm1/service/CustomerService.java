package com.cpm1.service;

import java.util.List;

import com.cpm1.exception.ResourceNotFoundException;
import com.cpm1.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId) throws ResourceNotFoundException;

	public void deleteCustomer(int theId) throws ResourceNotFoundException;

}
