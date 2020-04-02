package com.bankingsample.microservices.dashboardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bankingsample.microservices.dashboardservice")
public class DashboardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardServiceApplication.class, args);
	}

}
