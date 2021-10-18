package com.cpm1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cpm1.exception.ResourceNotFoundException;
import com.cpm1.model.Customer;
import com.cpm1.model.Notification;
import com.cpm1.service.CustomerService;

@RestController
public class CustomerController {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RestTemplate restTemplate;

	private static String mail_url = "http://mail-service/send";

	@GetMapping("/customer")
	public List<Customer> listCustomers() {
		List<Customer> theCustomers = customerService.getCustomers();
		return theCustomers;
	}

	@PostMapping("/customer")
	public void saveCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		Notification myMessage = new Notification(theCustomer.getEmail(),
				"You have register successfully with particular user name :  " + theCustomer.getUserName() + "");

		this.restTemplate.postForEntity(mail_url, myMessage, null);
	}

	@PutMapping("/customer")
	public void showFormForUpdate(@RequestBody Customer customer) throws ResourceNotFoundException {

		Customer theCustomer = customerService.getCustomer(customer.getId());
		customerService.saveCustomer(customer);

	}

	@DeleteMapping("/customer")
	public void deleteCustomer(@RequestParam("customerId") int theId) throws ResourceNotFoundException {
		customerService.deleteCustomer(theId);

	}
}
