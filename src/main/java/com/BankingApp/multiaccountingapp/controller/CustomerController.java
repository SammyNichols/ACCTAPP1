package com.BankingApp.multiaccountingapp.controller;



import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApp.multiaccountingapp.entity.Customer;
import com.BankingApp.multiaccountingapp.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	private CustomerService customerService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody Customer cust){
		try {
			return new ResponseEntity<Object>(customerService.register(cust), HttpStatus.CREATED);
		} catch (AuthenticationException e) {
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ResponseEntity<Object> login(@RequestBody Customer cust) {
		try {
			return new ResponseEntity<Object>(customerService.login(cust), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getCustomers(){
		return new ResponseEntity<Object>(customerService.getCustomers(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.PUT) 
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer cust, @PathVariable String username) {
		try {
			return new ResponseEntity<Object>(customerService.updateCustomer(cust, username), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
		try {
			customerService.deleteCustomer(id);
			return new ResponseEntity<Object>("Successfullt deleted customer with id :" + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	

}	