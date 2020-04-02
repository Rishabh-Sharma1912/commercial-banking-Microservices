package com.bankingsample.microservices.dashboardservice;

import javax.validation.constraints.Size;

public class Account {
	
	private int accountId;
	
	private String accountName;
	
	private String accountType;
	
	private int availableBalance;
	
	private int currentBalance;
	
	public Account() {
		
	}

	public Account(int accountId, @Size(min = 2) String accountName, @Size(min = 2) String accountType,
			int availableBalance, int currentBalance) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
		this.currentBalance = currentBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(int availableBalance) {
		this.availableBalance = availableBalance;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
}