package com.bakingsample.micfroservices.customerservice;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="account-service",url="localhost:5000")
public interface AccountServiceProxy {
	@PostMapping("/api/accountsMap")
	public void saveAccountMap(@Valid @RequestBody CustomerAccountMap customerAccountMap);
	
	@GetMapping("/api/accounts/{id}")
	public Account retrieveAccountById(@PathVariable int id);
}
