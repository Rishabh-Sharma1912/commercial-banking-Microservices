package com.bakingsample.micfroservices.customerservice;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.bankingsample.microservices.accountservice.exception.UserNotFoundException;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountServiceProxy proxy;
	
	@CrossOrigin
	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		return customerService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/customers/{id}")
	public Customer retrieveCustomerById(@PathVariable int id) {
		Customer customer = customerService.findById(id);
		if(customer == null) {
			throw new UserNotFoundException("id-"+ id);
		}
		return customer;
	}
	
	@CrossOrigin
	@PostMapping("/customers/accountId/{accountId}")
	public void saveCustomerWithAccount(@Valid @RequestBody Customer customer, @PathVariable int accountId) {
		proxy.retrieveAccountById(accountId);
		customer.setCustomerId(0);
		customerService.save(customer,accountId);
		proxy.saveAccountMap(new CustomerAccountMap(new CustomerAccountIdentity(customer.getCustomerId(),accountId)));
	}
	
	@CrossOrigin
	@PostMapping("/customers")
	public ResponseEntity<Object> saveCustomer(@Valid @RequestBody Customer customer) {
		customer.setCustomerId(0);
		Customer savedCustomer = customerService.save(customer);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedCustomer.getCustomerId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@CrossOrigin
	@PutMapping("/customers")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		Customer updatedCustomer = customerService.save(customer);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(updatedCustomer.getCustomerId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@CrossOrigin
	@PutMapping("/customers/customerId/{customerId}/accountId/{accountId}")
	public void addAccount(@PathVariable Integer customerId, @PathVariable int accountId) {
		proxy.retrieveAccountById(accountId);
		proxy.saveAccountMap(new CustomerAccountMap(new CustomerAccountIdentity(customerId,accountId)));
		customerService.addAccount(customerId, accountId);
	}

	@CrossOrigin
	@DeleteMapping("customers/{id}")
	public void deleteById(@PathVariable int id) {
		Customer tempCustomer = customerService.findById(id);
		
		if(tempCustomer == null) {
			throw new RuntimeException("Customer id not found - " + id);
		}
		
		customerService.deleteCustomer(id);
	}
}
