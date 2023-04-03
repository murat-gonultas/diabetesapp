package com.diabetes.murat.diabetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiabetesApplication {
	private static final Logger log = LoggerFactory.getLogger(DiabetesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DiabetesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FoodItemRepository repository) {
		return (args) -> {
			//repository.save(new FoodItem("kelle", 102.3));
			//repository.save(new FoodItem("Bread", 50));
			// fetch all customers
			log.info("Food items found with findAll():");
			log.info("-------------------------------");
			for (FoodItem fi : repository.findAll()) {
				log.info(fi.toString());
			}
			log.info("");
		};
	}

}


