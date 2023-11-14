package com.rodrigocarvalho.projectmanager.entrypoint.controller.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class PessoaResponse {
    private BigInteger id;

    private String nome;

    private LocalDate dataNascimento;

    private Boolean prjectFuncionario;
}
