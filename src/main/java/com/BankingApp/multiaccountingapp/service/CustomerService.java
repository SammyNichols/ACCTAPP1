package com.BankingApp.multiaccountingapp.service;

import javax.naming.AuthenticationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.BankingApp.multiaccountingapp.entity.Customer;
import com.BankingApp.multiaccountingapp.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer register(Customer cust) throws AuthenticationException {
		Customer customer = new Customer();
		customer.setUsername(cust.getUsername());
		customer.setHash((BCrypt.hashpw(cust.getPassword(), BCrypt.gensalt())));
		customer.setF_Name(cust.getF_Name());
		customer.setL_Name(cust.getL_Name());
		customer.setAddress(cust.getAddress());
		
		try {
			customerRepository.save(customer);
			return customer;
		} catch (DataIntegrityViolationException e) {
			logger.error("Error occurred while trying to register customer. " + e);
			throw new AuthenticationException("Username or Address not available.");
		}
	}
	
	public Customer login(Customer cust) throws AuthenticationException {
		Customer foundCustomer = customerRepository.findByUsername(cust.getUsername());
		if (foundCustomer != null && BCrypt.checkpw(cust.getPassword(), foundCustomer.getHash())) {
			return foundCustomer;
		} 
		throw new AuthenticationException ("Incorrect Username or Password.");
	}
	
	public Customer updateCustomer(Customer cust, String username) throws Exception {
		try {
			Customer oldCustomer = customerRepository.findByUsername(username);
			oldCustomer.setAddress(cust.getAddress());
			oldCustomer.setHash((BCrypt.hashpw(cust.getPassword(), BCrypt.gensalt())));
			oldCustomer.setF_Name(cust.getF_Name());
			oldCustomer.setL_Name(cust.getL_Name());
			return customerRepository.save(oldCustomer);
		} catch (Exception e) {
			logger.error("Exception occured while trying to update customer: " + username, e);
			throw new Exception("Unable to update customer.");
		}
	}
	
	public Iterable<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	public void deleteCustomer(Long id) throws Exception {
		try {
			customerRepository.delete(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to delete customer: " + id, e);
			throw new Exception("Unable to delete customer.");
		}
	}
}
