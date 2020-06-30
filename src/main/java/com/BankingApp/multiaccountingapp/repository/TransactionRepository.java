package com.BankingApp.multiaccountingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.BankingApp.multiaccountingapp.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
