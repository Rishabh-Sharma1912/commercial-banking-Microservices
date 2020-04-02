package com.bankingsample.microservices.dashboardservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="account-service",url="localhost:5000")
public interface AccountServiceProxy {
	
	@GetMapping("/api/accounts/customerId/{customerId}")
	public List<Account> retrieveByCustomerId(@PathVariable Integer customerId);
}
