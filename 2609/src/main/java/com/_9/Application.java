package com._9;

import com._9.dto.CategorySumDTO;
import com._9.projections.CategorySumProjection;
import com._9.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		List<CategorySumProjection> list = categoryRepository.search1();

		List<CategorySumDTO> result1 = list.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());

		System.out.println("*** RESULTADO SQL RAIZ:");
		if (result1.isEmpty()) {
			System.out.println("Nenhum filme encontrado para o gênero especificado.");
		} else {
			for (CategorySumDTO obj : result1) {
				System.out.println(obj);
			}
		}
		System.out.println("\n\n");

		List<CategorySumDTO> result2 = categoryRepository.search2();

		System.out.println("*** RESULTADO JPQL:");
		if (result2.isEmpty()) {
			System.out.println("Nenhum filme encontrado para o gênero especificado.");
		} else {
			for (CategorySumDTO obj : result2) {
				System.out.println(obj);
			}
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
