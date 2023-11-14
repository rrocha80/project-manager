package com.rodrigocarvalho.projectmanager.entrypoint.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class PessoaRequest {
    private BigInteger id;

    @NotBlank
    private String nome;

    @NotBlank
    private LocalDate dataNascimento;

    @NotBlank
    private Boolean prjectFuncionario;
}
