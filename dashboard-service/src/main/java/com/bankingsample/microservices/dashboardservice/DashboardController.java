package com.bankingsample.microservices.dashboardservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DashboardController {
	
	@Autowired
	AccountServiceProxy accountProxy;
	
	@GetMapping("/dashboards/{customerId}")
	public List<Account> getAccountInfo(@PathVariable Integer customerId){
		return accountProxy.retrieveByCustomerId(customerId);
	}
}
