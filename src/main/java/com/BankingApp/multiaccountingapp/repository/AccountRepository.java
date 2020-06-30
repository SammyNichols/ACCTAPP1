package com.BankingApp.multiaccountingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.BankingApp.multiaccountingapp.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
