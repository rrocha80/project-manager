package com.rodrigocarvalho.projectmanager.entrypoint.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PessoaResponse {

    private BigInteger id;

    private String nome;

    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    private Boolean funcionario;

    private Boolean gerente;
}
