package com._7;

import com._7.dto.LawyerMinDTO;
import com._7.projections.LawyerMinProjection;
import com._7.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository lawyerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<LawyerMinProjection> list = lawyerRepository.search1();
		List<LawyerMinDTO> result1 = list.stream().map(x -> new LawyerMinDTO(x)).collect(Collectors.toList());

		System.out.println("*** RESULTADO SQL RAIZ:");
		if (result1.isEmpty()) {
			System.out.println("Nenhum filme encontrado para o gênero especificado.");
		} else {
			for (LawyerMinDTO obj : result1) {
				System.out.println(obj);
			}
		}
		System.out.println("\n\n");

	}
}
