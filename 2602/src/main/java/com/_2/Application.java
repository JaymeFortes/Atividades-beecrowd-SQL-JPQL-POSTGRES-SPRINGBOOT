package com._2;

import com._2.dto.CustomerMinDTO;
import com._2.projections.CustomerMinProjection;
import com._2.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CustomerMinProjection> list = customerRepository.search1("rs");
		List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());

		System.out.println("*** RESULTADO SQL RAIZ:");
		for (CustomerMinDTO obj : result1) {
			System.out.println(obj.getName());
		}
		System.out.println("\n\n");

		List<CustomerMinDTO> result2 = customerRepository.search2("rs");

		System.out.println("*** RESULTADO JPQL:");
		for (CustomerMinDTO obj : result2) {
			System.out.println(obj.getName());
		}
	}
}
