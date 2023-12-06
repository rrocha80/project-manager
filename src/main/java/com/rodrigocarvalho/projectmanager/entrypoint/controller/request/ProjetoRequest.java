package com.rodrigocarvalho.projectmanager.entrypoint.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.RiscoEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
@Data
public class ProjetoRequest {

    private BigInteger id;

    @JsonProperty("nome")
    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataPrevisao;

    private LocalDate dataFim;

    private String descricao;

    private StatusEnum status;

    private Float orcamento;

    private RiscoEnum risco;

    private PessoaEntity gerente;
}
