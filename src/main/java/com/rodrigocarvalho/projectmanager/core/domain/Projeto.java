package com.rodrigocarvalho.projectmanager.core.domain;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.RiscoEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;

import java.math.BigInteger;
import java.time.LocalDate;

public class Projeto {

    public Projeto(){}

    public Projeto(BigInteger id, String nome, LocalDate dataInicio, LocalDate dataPrevisao, LocalDate dataFim
            , String descricao, StatusEnum status, float orcamento, RiscoEnum risco, Pessoa gerente) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataPrevisao = dataPrevisao;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.status = status;
        this.orcamento = orcamento;
        this.risco = risco;
        this.gerente = gerente;
    }

    private BigInteger id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataPrevisao;
    private LocalDate dataFim;
    private String descricao;
    private StatusEnum status;
    private float orcamento;
    private RiscoEnum risco;
    private Pessoa gerente;

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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(LocalDate dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }

    public RiscoEnum getRisco() {
        return risco;
    }

    public void setRisco(RiscoEnum risco) {
        this.risco = risco;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public void setIdGerente(Pessoa gerente) {
        this.gerente = gerente;
    }
}
