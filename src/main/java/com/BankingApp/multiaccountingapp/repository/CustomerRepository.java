package com.BankingApp.multiaccountingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.BankingApp.multiaccountingapp.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	public Customer findByUsername(String username);

}
