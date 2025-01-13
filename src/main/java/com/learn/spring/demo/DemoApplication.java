package com.learn.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		BigDecimal qty = BigDecimal.valueOf(0.00);
		if (qty.compareTo(BigDecimal.ZERO) == 0) {
			System.out.println("Equal");
		}

	}
}
