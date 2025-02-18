package com._0.dto;

import com._0.projections.EmpregadosDepProjection;

public class EmpregoDeptDTO {

    private String cpf;
    private String enome;
    private String dnome;

    public EmpregoDeptDTO() {}

    public EmpregoDeptDTO(String cpf, String enome, String dnome) {
        this.cpf = cpf;
        this.enome = enome;
        this.dnome = dnome;
    }

    public EmpregoDeptDTO(EmpregadosDepProjection projection) {
        cpf = projection.getCpf();
        enome = projection.getENome();
        dnome = projection.getDNome();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnome() {
        return enome;
    }

    public void setEnome(String enome) {
        this.enome = enome;
    }

    public String getDnome() {
        return dnome;
    }

    public void setDnome(String dnome) {
        this.dnome = dnome;
    }

    @Override
    public String toString() {
        return "EmpregoDeptDTO{" +
                "cpf='" + cpf + '\'' +
                ", enome='" + enome + '\'' +
                ", dnome='" + dnome + '\'' +
                '}';
    }
}
