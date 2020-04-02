package com.bakingsample.micfroservices.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Transactional
	public Customer findById(Integer id) {
		return customerDao.findById(id);
	}
	
	@Transactional
	public void save(Customer customer,int accountId) {
		customerDao.saveWithAccount(customer,accountId);
		//customerDao.findById(customer.getCustomerId());
	}
	
	@Transactional
	public Customer save(Customer customer) {
		customerDao.save(customer);
		Customer savedAccount = customerDao.findById(customer.getCustomerId());
		return savedAccount;
	}
	
	@Transactional
	public Customer update(Customer customer) {
		customerDao.update(customer);
		Customer savedAccount = customerDao.findById(customer.getCustomerId());
		return savedAccount;
	}
	
	@Transactional
	public void addAccount(Integer customerId, int accountId) {
		customerDao.addAccount(customerId, accountId);
	}
	
	@Transactional
	public void deleteCustomer(Integer id) {
		customerDao.deleteCustomer(id);
	}

}
