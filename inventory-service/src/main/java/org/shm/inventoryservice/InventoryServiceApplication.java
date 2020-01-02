package org.shm.inventoryservice;

import org.shm.inventoryservice.dao.ProductRepository;
import org.shm.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null, "Computer HP 650", 6500));
			productRepository.save(new Product(null, "Computer Epson 500", 6500));
			productRepository.save(new Product(null, "Computer Mac Book Pro", 12000));

			productRepository.findAll().forEach(System.out::println);
		};
	}
}
