package com.rodrigocarvalho.projectmanager.entrypoint.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.RiscoEnum;
import com.rodrigocarvalho.projectmanager.core.domain.Enum.StatusEnum;
import com.rodrigocarvalho.projectmanager.dataprovider.repository.entity.PessoaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ProjetoResponse {
    private BigInteger id;

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataPrevisao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataFim;

    private String descricao;

    private StatusEnum status;

    private float orcamento;

    private RiscoEnum risco;

    private PessoaEntity gerente;

    private List<PessoaEntity> membros;
}
