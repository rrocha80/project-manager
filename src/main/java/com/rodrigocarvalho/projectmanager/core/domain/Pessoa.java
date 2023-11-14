package com.rodrigocarvalho.projectmanager.core.domain;

import java.math.BigInteger;
import java.time.LocalDate;

public class Pessoa {

    public Pessoa(){}

    public Pessoa(BigInteger id, String nome, LocalDate dataNascimento, Boolean prjectFuncionario) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.prjectFuncionario = prjectFuncionario;
    }

    private BigInteger id;
    private String nome;
    private LocalDate dataNascimento;
    private Boolean prjectFuncionario;

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

    public Boolean getPrjectFuncionario() {
        return prjectFuncionario;
    }

    public void setPrjectFuncionario(Boolean prjectFuncionario) {
        this.prjectFuncionario = prjectFuncionario;
    }
}
