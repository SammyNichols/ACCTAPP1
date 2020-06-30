package com.BankingApp.multiaccountingapp.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.BankingApp.multiaccountingapp.util.AccountType;

@Entity
public class Account {
	
	private Long id;
	private Customer customer;
	private String a_Name;
	private AccountType account_type;
	private double balance;
	private Set<Transaction> transactions;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getA_Name() {
		return a_Name;
	}
	
	public void setA_Name(String a_Name) {
		this.a_Name = a_Name;
	}
	
	public AccountType getAccount_type() {
		return account_type;
	}
	
	public void setAccount_type(AccountType account_type) {
		this.account_type = account_type;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@OneToMany(mappedBy = "account")
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	

	

}
