package com.rodrigocarvalho.projectmanager.entrypoint.controller.response;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.RiscoEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;

import java.math.BigInteger;
import java.time.LocalDate;

public class ProjetoResponse {
    private BigInteger id;

    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataPrevisao;

    private LocalDate dataFim;

    private String descricao;

    private StatusEnum status;

    private float orcamento;

    private RiscoEnum risco;

    private PessoaEntity gerente;
}
