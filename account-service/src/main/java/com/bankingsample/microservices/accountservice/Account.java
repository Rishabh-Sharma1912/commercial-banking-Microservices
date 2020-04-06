package com.bankingsample.microservices.accountservice;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@Column(name="account_id")
	private int accountId;
	
	@Size(min = 2)
	@Column(name="account_name")
	private String accountName;
	
	@Size(min = 2)
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="available_balance")
	private int availableBalance;
	
	@Column(name="current_balance")
	private int currentBalance;
	
	@Column(name="currency_type")
	private String currencyType;
	
	@Column(name="bsb")
	private Integer bsb;
	
	@Column(name="creation_date")
	@CreationTimestamp
	private Date creationDate;
	
	public Account() {
		
	}

	public Account(int accountId, @Size(min = 2) String accountName, @Size(min = 2) String accountType,
			int availableBalance, int currentBalance, String currencyType, Integer bsb, Date creationDate) {
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