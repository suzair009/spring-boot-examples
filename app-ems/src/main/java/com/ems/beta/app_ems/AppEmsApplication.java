package com.ems.beta.app_ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppEmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEmsApplication.class, args);
		System.out.println("EMS Application is running...");
	}

}
