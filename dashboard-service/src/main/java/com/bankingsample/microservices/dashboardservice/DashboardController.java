package com.bankingsample.microservices.dashboardservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DashboardController {
	
	@Autowired
	AccountServiceProxy accountProxy;

	@CrossOrigin
	@GetMapping("/dashboards/{customerId}")
	public List<Account> getAccountInfo(@PathVariable Integer customerId){
		return accountProxy.retrieveByCustomerId(customerId);
	}
}
