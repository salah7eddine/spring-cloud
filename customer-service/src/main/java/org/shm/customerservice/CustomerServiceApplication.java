package org.shm.customerservice;

import org.shm.customerservice.dao.CustomerRepository;
import org.shm.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
@EnableEurekaClient
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null, "Hamza", "Hamza@Gmail.com"));
			customerRepository.save(new Customer(null, "Meryem", "meryem@Gmail.com"));
			customerRepository.save(new Customer(null, "Salah-eddine", "salah@Gmail.com"));

			customerRepository.findAll().forEach(System.out::println);
		};
	}
}