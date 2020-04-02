package com.bankingsample.microservices.accountservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Transactional
	public Account findById(int id) {
		return accountDao.findById(id);
	}
	
	@Transactional
	public void save(Account account) {
		accountDao.save(account);
	}
	
	@Transactional
	public void saveAccountMap(CustomerAccountMap customerAccountMap) {
		accountDao.saveAccountMap(customerAccountMap);
	}
	
	@Transactional
	public List<Account> findByCustomerId(Integer customerId) {
		return accountDao.findByCustomerId(customerId);
	}
	
	@Transactional
	public void deleteAccount(int id) {
		accountDao.deleteAccount(id);
	}

}
