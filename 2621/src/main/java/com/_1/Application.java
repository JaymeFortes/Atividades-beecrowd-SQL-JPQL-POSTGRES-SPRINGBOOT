package com._1;

import com._1.dto.ProductMinDTO;
import com._1.projections.ProductMinProjection;
import com._1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<ProductMinProjection> list = productRepository.search1(10, 20, "p");
        List<ProductMinDTO> result1 = list.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());

        System.out.println("*** RESULTADO SQL RAIZ:");
        if (result1.isEmpty()) {
            System.out.println("Nenhum filme encontrado para o gênero especificado.");
        } else {
            for (ProductMinDTO obj : result1) {
                System.out.println(obj);
            }
        }
        System.out.println("\n\n");

        List<ProductMinDTO> result2 = productRepository.search2(10, 20, "P");

        System.out.println("*** RESULTADO JPQL:");
        if (result2.isEmpty()) {
            System.out.println("Nenhum filme encontrado para o gênero especificado.");
        } else {
            for (ProductMinDTO obj : result2) {
                System.out.println(obj);
            }
        }

    }
}

