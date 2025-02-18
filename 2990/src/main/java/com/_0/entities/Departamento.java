package com._0.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    private Long dnumero;
    private String dnome;

    @OneToMany(mappedBy = "departamento")
    private List<Empregado> empregados = new ArrayList<Empregado>();

    @ManyToOne
    @JoinColumn(name = "cpf_gerente")
    private Empregado empregado;

    public Departamento() {
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public Long getdNumero() {
        return dnumero;
    }

    public void setdNumero(Long dNumero) {
        this.dnumero = dNumero;
    }

    public String getdNome() {
        return dnome;
    }

    public void setdNome(String dNome) {
        this.dnome = dNome;
    }
}
