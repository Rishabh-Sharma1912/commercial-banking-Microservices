package com.bankingsample.microservices.dashboardservice;

import java.util.Date;

public class Account {
	
	private int accountId;
	
	private String accountName;
	
	private String accountType;
	
	private int availableBalance;
	
	private int currentBalance;

	private String currencyType;
	
	private Integer bsb;
	
	private Date creationDate;
	
	public Account() {
		
	}

	public Account(int accountId, String accountName, String accountType, int availableBalance, int currentBalance,
			String currencyType, Integer bsb, Date creationDate) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
		this.currentBalance = currentBalance;
		this.currencyType = currencyType;
		this.bsb = bsb;
		this.creationDate = creationDate;
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

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public Integer getBsb() {
		return bsb;
	}

	public void setBsb(Integer bsb) {
		this.bsb = bsb;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}