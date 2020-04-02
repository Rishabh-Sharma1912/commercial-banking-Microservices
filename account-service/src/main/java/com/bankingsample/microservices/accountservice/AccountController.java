package com.bankingsample.microservices.accountservice;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingsample.microservices.accountservice.exception.AccountIdNotFoundException;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccountService accountService;
	
	@CrossOrigin
	@GetMapping("/accounts")
	public List<Account> retrieveAllAccounts() {
		return accountService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/accounts/{id}")
	public Account retrieveAccountById(@PathVariable int id) {
		Account account = accountService.findById(id);
		if(account == null) {
			throw new AccountIdNotFoundException("Account_id-"+ id);
		}
		return account;
	}
	
	@CrossOrigin
	@GetMapping("/accounts/customerId/{customerId}")
	public List<Account> retrieveByCustomerId(@PathVariable Integer customerId) {
		List<Account> accounts = accountService.findByCustomerId(customerId);
		logger.info(accounts.toString());
		return accounts;
	}
	
	@CrossOrigin
	@PostMapping("/accounts")
	public void saveAccount(@Valid @RequestBody Account account) {
		account.setAccountId(0);
		accountService.save(account);
		/*
		 * URI location = ServletUriComponentsBuilder .fromCurrentRequest()
		 * .path("/{id}") .buildAndExpand(savedAccount.getAccountId()).toUri();
		 */
		//return ResponseEntity.created(location).build();
		//return savedAccount;
	}
	
	@CrossOrigin
	@PostMapping("/accountsMap")
	public void saveAccountMap(@Valid @RequestBody CustomerAccountMap customerAccountMap) {
		accountService.saveAccountMap(customerAccountMap);
	}
	
	@CrossOrigin
	@PutMapping("/accounts")
	public void updateAccount(@RequestBody Account account) {
		accountService.save(account);
		/*
		 * Account updatedAccount = accountService.save(account); URI location =
		 * ServletUriComponentsBuilder .fromCurrentRequest() .path("/{id}")
		 * .buildAndExpand(updatedAccount.getAccountId()).toUri(); return
		 * ResponseEntity.created(location).build();
		 */
	}

	@CrossOrigin
	@DeleteMapping("accounts/{id}")
	public void deleteById(@PathVariable int id) {
		Account tempAccount = accountService.findById(id);
		
		if(tempAccount == null) {
			throw new RuntimeException("Account id not found - " + id);
		}
		
		accountService.deleteAccount(id);
	}
}
