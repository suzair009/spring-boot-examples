package com.ems.beta.app_ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.ems.beta.app_ems"})
@EntityScan("com.ems.beta.app_ems")
@EnableJpaRepositories
public class AppEmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEmsApplication.class, args);
		System.out.println("EMS Application is running...");
	}

}
