package com.example.fullstackspringapplication;

import com.example.fullstackspringapplication.customer.Customer;
import com.example.fullstackspringapplication.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository){
		return args -> {
//			customers=new ArrayList<>();

			Customer naveen=new Customer(
					"Naveen",
					"naveen@gmail.com",
					22
			);
//			customers.add(naveen);

			Customer prajwal=new Customer(
					"Prajwal",
					"prajwal@gmail.com",
					23
			);
//			customers.add(prajwal);

			List<Customer> customers = List.of(naveen, prajwal);
			customerRepository.saveAll(customers);
		};
	}
}
