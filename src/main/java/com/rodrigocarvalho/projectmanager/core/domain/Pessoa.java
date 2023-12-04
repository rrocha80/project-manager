package com.rodrigocarvalho.projectmanager.core.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

public class Pessoa implements Serializable {

    public Pessoa(){}

    public Pessoa(BigInteger id){this.id = id;}

    public Pessoa(BigInteger id, String nome, LocalDate dataNascimento, String cpf, Boolean funcionario, Boolean gerente) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.funcionario = funcionario;
        this.gerente = gerente;
    }

    private BigInteger id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Boolean funcionario;
    private Boolean gerente;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }

    public Boolean getGerente() {
        return gerente;
    }

    public void setGerente(Boolean gerente) {
        this.gerente = gerente;
    }
}
