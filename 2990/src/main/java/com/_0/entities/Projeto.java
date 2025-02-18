package com._0.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projetos")
public class Projeto {

    @Id
    public Long pnumero;
    public String pnome;

    @ManyToOne
    @JoinColumn(name = "dnumero")
    private Departamento departamento;

    @ManyToMany(mappedBy = "projetosOndeTrabalha")
    private Set<Empregado> empregados = new HashSet<>();

    public Projeto() {}

    public Set<Empregado> getEmpregados() {
        return empregados;
    }

    public Long getpNumero() {
        return pnumero;
    }

    public void setpNumero(Long pNumero) {
        this.pnumero = pNumero;
    }

    public String getpNome() {
        return pnome;
    }

    public void setpNome(String pNome) {
        this.pnome = pNome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
