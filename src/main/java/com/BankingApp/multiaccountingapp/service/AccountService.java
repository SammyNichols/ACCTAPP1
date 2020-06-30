package com.BankingApp.multiaccountingapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingApp.multiaccountingapp.entity.Account;
import com.BankingApp.multiaccountingapp.repository.AccountRepository;
import com.BankingApp.multiaccountingapp.repository.CustomerRepository;

@Service
public class AccountService {
	
	private static final Logger logger = LogManager.getLogger(AccountService.class);
	
	@Autowired
	private AccountRepository acctRepo;
	private CustomerRepository customerRepository;
	
	public Account createAccount(Account acct, String username) throws Exception {
		Account account = new Account();
		account.setCustomer(customerRepository.findByUsername(username));
		account.setA_Name(acct.getA_Name());
		account.setAccount_type(acct.getAccount_type());
		account.setBalance(acct.getBalance());
		try {
			acctRepo.save(account);
			return account;
		} catch (Exception e) {
			logger.error("Error occurred while trying to create account for username: " + username, e);
			throw e;
		}
	}

}
