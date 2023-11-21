package com.rodrigocarvalho.projectmanager.entrypoint.controller.response;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.CargoEnum;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class PessoaResponse {
    private BigInteger id;

    private String nome;

    private CargoEnum cargo;

    private LocalDate dataNascimento;

    private Boolean prjectFuncionario;
}
