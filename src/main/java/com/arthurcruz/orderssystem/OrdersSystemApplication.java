package com.arthurcruz.orderssystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arthurcruz.orderssystem.domain.Category;
import com.arthurcruz.orderssystem.repositories.CategoryRepository;

@SpringBootApplication
public class OrdersSystemApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OrdersSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Esportes");
		Category cat2 = new Category(null, "Roupas");
	
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}
	
	

}
