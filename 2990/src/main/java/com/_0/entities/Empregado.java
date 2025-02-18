package com._0.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "empregados")
public class Empregado {
    @Id
    private String  cpf;
    private String enome;
    private double salario;

    @ManyToOne
    @JoinColumn(name = "cpf_supervisor")
    private Empregado supervisor;

    @OneToMany(mappedBy = "supervisor")
    private List<Empregado> supervisonados = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "dnumero")
    private Departamento departamento;

    @ManyToMany
    @JoinTable(name = "trabalha",
            joinColumns = @JoinColumn(name = "cpf_emp"),
            inverseJoinColumns = @JoinColumn(name = "pnumero"))
    private Set<Projeto> projetosOndeTrabalha = new HashSet<>();

    public Empregado() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String geteNome() {
        return enome;
    }

    public void seteNome(String eNome) {
        this.enome = eNome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Empregado getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Empregado supervisor) {
        this.supervisor = supervisor;
    }

    public List<Empregado> getSupervisonados() {
        return supervisonados;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Set<Projeto> getProjetosOndeTrabalha() {
        return projetosOndeTrabalha;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
