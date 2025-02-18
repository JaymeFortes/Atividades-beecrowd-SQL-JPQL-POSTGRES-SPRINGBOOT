package com._0.repositories;

import com._0.dto.EmpregoDeptDTO;
import com._0.entities.Empregado;
import com._0.projections.EmpregadosDepProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {


    @Query(nativeQuery = true, value = "SELECT empregados.cpf AS cpf, empregados.enome AS enome, departamentos.dnome AS dnome "
            + "FROM empregados "
            + "INNER JOIN departamentos ON empregados.dnumero = departamentos.dnumero "
            + "WHERE empregados.cpf NOT IN ( "
            + " SELECT empregados.cpf "
            + " FROM empregados "
            + " INNER JOIN trabalha ON trabalha.cpf_emp = empregados.cpf "
            + ") "
            + "ORDER BY empregados.cpf")
    List<EmpregadosDepProjection> search1();

    @Query("SELECT new com._0.dto.EmpregoDeptDTO(obj.cpf, obj.enome, obj.departamento.dnome) "
            + "FROM Empregado obj "
            + "WHERE obj.cpf NOT IN ( "
            + " SELECT obj.cpf "
            + "FROM Empregado obj "
            + "INNER JOIN obj.projetosOndeTrabalha "
            + ") "
            + "ORDER BY obj.cpf")
    List<EmpregoDeptDTO> search2();

    @Query(nativeQuery = true, value = "SELECT empregados.cpf, empregados.enome, departamentos.dnome " +
            "FROM empregados " +
            "INNER JOIN departamentos ON empregados.dnumero = departamentos.dnumero " +
            "LEFT JOIN trabalha ON trabalha.cpf_emp = empregados.cpf " +
            "WHERE trabalha.cpf_emp IS NULL " +
            "ORDER BY empregados.cpf")

    List<EmpregadosDepProjection> search3();

}
