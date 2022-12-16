package com.investment.stocks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Investments API", version = "1.0", description = "This API allows for storing companies data and track investments"))
public class StocksApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StocksApplication.class, args);
	}

}
