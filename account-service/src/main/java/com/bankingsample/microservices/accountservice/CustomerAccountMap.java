package com.bankingsample.microservices.accountservice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customer_account_map")
public class CustomerAccountMap {
	
	@EmbeddedId
	private CustomerAccountIdentity customerAccountIdentity;
	
	public CustomerAccountMap() {
		
	}

	public CustomerAccountMap(CustomerAccountIdentity customerAccountIdentity) {
		super();
		this.customerAccountIdentity = customerAccountIdentity;
	}

	public CustomerAccountIdentity getCustomerAccountIdentity() {
		return customerAccountIdentity;
	}

	public void setCustomerAccountIdentity(CustomerAccountIdentity customerAccountIdentity) {
		this.customerAccountIdentity = customerAccountIdentity;
	}
}
