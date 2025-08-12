package com.fya.credit.fya_credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FyaCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(FyaCreditApplication.class, args);
	}

}
