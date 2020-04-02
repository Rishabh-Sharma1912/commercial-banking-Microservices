package com.bankingsample.microservices.accountservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerAccountIdentity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5911540857010322238L;

	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="account_id")
	private int accountId;
	
	public CustomerAccountIdentity() {
		
	}

	public CustomerAccountIdentity(Integer customerId, int accountId) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
