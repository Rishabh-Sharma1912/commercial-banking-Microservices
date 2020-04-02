package com.bakingsample.micfroservices.customerservice;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager entityManager;
	
	/**
	 * Returns Account details of all accounts.
	 */
	public List<Customer> findAll() {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//query to fetch all records
		Query<Customer> query = currentSession.createQuery(
								"from Customer where customerId!=:customerId", Customer.class);
		//get account details of all accounts
		query.setParameter("customerId", 9999999);
		List<Customer> customer = query.getResultList();
		//return the result
		return customer;
	}

	/**
	 * Returns Account details by account id.
	 */
	public Customer findById(Integer id) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//get account details by id and return the result
		Customer customer = currentSession.get(Customer.class, id);
		//return the result
		return customer;
	}
	
	/**
	 * Creates a new account.
	 */
	public void save(Customer customer) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//create account
		currentSession.save(customer);
	}
	
	public void update(Customer customer) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//create account
		currentSession.update(customer);
	}
	
	public void saveWithAccount(Customer customer,int accountId) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//create account
		Integer id = (Integer) currentSession.save(customer);
		logger.info(id.toString());
		currentSession.save(new CustomerAccountMap(new CustomerAccountIdentity(id, accountId)));
	}
	
	public void addAccount(Integer customerId,int accountId) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(new CustomerAccountMap(new CustomerAccountIdentity(customerId, accountId)));
	}
	
	/**
	 * Creates a new account.
	 */
	public void deleteCustomer(Integer id) {
		//get current session
		Session currentSession = entityManager.unwrap(Session.class);
		//query for deleting the account
		Query<Customer> query = currentSession.createQuery(
									"delete from Customer where customerId=:id",Customer.class);
		query.setParameter(id, id);
		query.executeUpdate();
	}

}
