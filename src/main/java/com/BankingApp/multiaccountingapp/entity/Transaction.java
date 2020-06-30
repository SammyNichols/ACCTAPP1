package com.BankingApp.multiaccountingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.BankingApp.multiaccountingapp.util.TransactionType;

@Entity
public class Transaction {
	
	private Long id;
	private Account account;
	private String t_note;
	private double amount;
	private TransactionType transaction_type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String getT_note() {
		return t_note;
	}
	
	public void setT_note(String t_note) {
		this.t_note = t_note;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public TransactionType getTransaction_type() {
		return transaction_type;
	}
	
	public void setTransaction_type(TransactionType transaction_type) {
		this.transaction_type = transaction_type;
	}
	

}
