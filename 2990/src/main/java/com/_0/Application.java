package com._0;

import com._0.dto.EmpregoDeptDTO;
import com._0.projections.EmpregadosDepProjection;
import com._0.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Override
    public void run(String... args) throws Exception {
        List<EmpregadosDepProjection> list = empregadoRepository.search1();
        List<EmpregoDeptDTO> result1 = list.stream().map(x -> new EmpregoDeptDTO(x)).collect(Collectors.toList());

        System.out.println("*** RESULTADO SQL RAIZ:");
        if (result1.isEmpty()) {
            System.out.println("Nenhum dado encontrado.");
        } else {
            for (EmpregoDeptDTO obj : result1) {
                System.out.println(obj);
            }
        }
        System.out.println("\n\n");

        List<EmpregoDeptDTO> result2 = empregadoRepository.search2();

        System.out.println("*** RESULTADO JPQL:");
        if (result2.isEmpty()) {
            System.out.println("Nenhum dado encontrado.");
        } else {
            for (EmpregoDeptDTO obj : result2) {
                System.out.println(obj);
            }
        }

        System.out.println("\n\n");

        List<EmpregadosDepProjection> list3 = empregadoRepository.search3();
        List<EmpregoDeptDTO> result3 = list.stream().map(x -> new EmpregoDeptDTO(x)).collect(Collectors.toList());

        System.out.println("*** RESULTADO SQL RAIZ 2:");
        if (result1.isEmpty()) {
            System.out.println("Nenhum dado encontrado.");
        } else {
            for (EmpregoDeptDTO obj : result1) {
                System.out.println(obj);
            }
        }
        System.out.println("\n\n");

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
