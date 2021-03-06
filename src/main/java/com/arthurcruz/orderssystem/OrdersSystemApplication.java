package com.arthurcruz.orderssystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arthurcruz.orderssystem.domain.Address;
import com.arthurcruz.orderssystem.domain.Category;
import com.arthurcruz.orderssystem.domain.City;
import com.arthurcruz.orderssystem.domain.Client;
import com.arthurcruz.orderssystem.domain.Country;
import com.arthurcruz.orderssystem.domain.Product;
import com.arthurcruz.orderssystem.domain.State;
import com.arthurcruz.orderssystem.domain.enums.ClientType;
import com.arthurcruz.orderssystem.repositories.AddressRepository;
import com.arthurcruz.orderssystem.repositories.CategoryRepository;
import com.arthurcruz.orderssystem.repositories.CityRepository;
import com.arthurcruz.orderssystem.repositories.ClientRepository;
import com.arthurcruz.orderssystem.repositories.CountryRepository;
import com.arthurcruz.orderssystem.repositories.ProductRepository;
import com.arthurcruz.orderssystem.repositories.StateRepository;

@SpringBootApplication
public class OrdersSystemApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrdersSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		Country pais1 = new Country(null, "Brasil"); 
		
		State est1 = new State(null, "Minas Gerais", pais1);
		State est2 = new State(null, "São Paulo", pais1);

		City c1 = new City(null, "Uberlândia", est1, pais1);
		City c2 = new City(null, "São Paulo", est2, pais1);
		City c3 = new City(null, "Campinas", est2, pais1);

		Client cli1 = new Client(null, "Maria", "maria@gmail.com", "91886789037", ClientType.NATURAL_PERSON);
		cli1.getPhones().addAll(Arrays.asList("9192327421", "4677616661"));

		Address e1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "00000000", c1, cli1);
		Address e2 = new Address(null, "Aveida Matos", "105", "Sala 800", "Centro", "01000000", c2, cli1);

		cli1.getAddresses().addAll(Arrays.asList(e1, e2));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		countryRepository.saveAll(Arrays.asList(pais1));
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(e1, e2));

	}

}
