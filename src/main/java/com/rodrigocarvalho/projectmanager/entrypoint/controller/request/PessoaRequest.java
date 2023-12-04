package com.rodrigocarvalho.projectmanager.entrypoint.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class PessoaRequest {

    private BigInteger id;

    @NotNull
    @JsonProperty("nome")
    private String nome;

    @NotNull
    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("dataNascimento")
    private LocalDate dataNascimento;

    @JsonProperty("funcionario")
    private Boolean funcionario;

    @JsonProperty("gerente")
    private Boolean gerente;
}
