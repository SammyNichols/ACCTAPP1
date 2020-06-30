package com.BankingApp.multiaccountingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.BankingApp.multiaccountingapp.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
