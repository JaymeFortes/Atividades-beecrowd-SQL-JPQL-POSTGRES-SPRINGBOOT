package com._1;

import com._1.dto.MovieMinDTO;
import com._1.projections.MovieMinProjection;
import com._1.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovieMinProjection> list = repository.search1("Action");

		List<MovieMinDTO> result1 = list.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());

		System.out.println("*** RESULTADO SQL RAIZ:");
		if (result1.isEmpty()) {
			System.out.println("Nenhum filme encontrado para o gênero especificado.");
		} else {
			for (MovieMinDTO obj : result1) {
				System.out.println(obj);
			}
		}
		System.out.println("\n\n");

		List<MovieMinDTO> result2 = repository.search2("Action");

		System.out.println("*** RESULTADO JPQL:");
		if (result2.isEmpty()) {
			System.out.println("Nenhum filme encontrado para o gênero especificado.");
		} else {
			for (MovieMinDTO obj : result2) {
				System.out.println(obj);
			}
		}

	}
}
