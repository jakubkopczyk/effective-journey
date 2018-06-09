package com.wsjk.springpharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

@SpringBootApplication
public class SpringPharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPharmacyApplication.class, args);
	}
}
