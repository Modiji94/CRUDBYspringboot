package com.becoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class ProductManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementBackendApplication.class, args);
	}

}
