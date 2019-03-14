package com.intuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayAppApplication.class, args);
	}

}
