package com.bankingsample.microservices.accountservice;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {
	
	@Autowired
	private EntityManager entityManager;
	
	/**
	 * Returns Account details of all accounts.
	 */
	public List<Account> findAll() {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//query to fetch all records
		Query<Account> query = currentSession.createQuery("from Account", Account.class);
		//get account details of all accounts
		List<Account> accounts = query.getResultList();
		//return the result
		return accounts;
	}

	/**
	 * Returns Account details by account id.
	 */
	public Account findById(int id) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//get account details by id and return the result
		Account acccount = currentSession.get(Account.class, id);
		//return the result
		return acccount;
	}
	
	public List<Account> findByCustomerId(Integer customerId) {
		List<Account> accounts = new ArrayList<>();
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//get account details by id and return the result
		Query<CustomerAccountMap> query = currentSession.createQuery(
					"from CustomerAccountMap c where c.customerAccountIdentity.customerId=:id",CustomerAccountMap.class);
		query.setParameter("id", customerId);
		List<CustomerAccountMap> customerAccountMaps = new ArrayList<>();
		customerAccountMaps = query.getResultList();
		for(CustomerAccountMap cam:customerAccountMaps) {
			accounts.add(currentSession.get(Account.class, cam.getCustomerAccountIdentity().getAccountId()));
		}
		//return the result
		return accounts;
	}
	
	/**
	 * Creates a new account.
	 */
	public void save(Account account) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//create account
		currentSession.saveOrUpdate(account);
	}
	
	public void saveAccountMap(CustomerAccountMap customerAccountMap) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//create account
		//AccountCustomerIdentity aci = accountCustomerMap.getCustomerAccountIdentity();
		//currentSession.save(new AccountCustomerMap(new AccountCustomerIdentity(aci.getCustomerId(),aci.getAccountId())));
		currentSession.save(customerAccountMap);
	}
	
	/**
	 * Creates a new account.
	 */
	public void deleteAccount(int id) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//query for deleting the account
		Query<Account> query = currentSession.createQuery(
									"delete from Account where accountId=:id",Account.class);
		query.setParameter(id, id);
		query.executeUpdate();
	}

}
