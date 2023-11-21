package com.rodrigocarvalho.projectmanager.entrypoint.controller.request;

import com.rodrigocarvalho.projectmanager.core.domain.Enum.CargoEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PessoaRequest {

    private BigInteger id;

    @NotNull
    private String nome;

    @NotNull
    private CargoEnum cargo;


    private LocalDate dataNascimento;


    private Boolean prjectFuncionario;
}
